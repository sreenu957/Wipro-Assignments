import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Classroomservice } from '../../service/classroom-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-classroom',
  imports: [FormsModule],
  templateUrl: './add-classroom.html',
  styleUrl: './add-classroom.css'
})
export class AddClassroom {

  classroom = {
    name: '',
    location:'',
    capacity:0,
    type:''
  }
  message='';
  
  constructor(private classroomService:Classroomservice,private router:Router){}

  async onSubmit() {
    console.log("Submitting classroom:", this.classroom);

    this.classroomService.addClassroom(this.classroom).subscribe({
      next: (response) => {
        console.log("Classroom saved:", response);
        this.message = "Classroom added successfully!";
        this.router.navigate(['/classroom']);
      },
      error: (err) => {
        console.error("Error while saving classroom:", err);
        this.message = "Error adding classroom!";
      }
    });
  }
}