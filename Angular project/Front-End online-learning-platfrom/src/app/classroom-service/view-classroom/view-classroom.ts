import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Classroomservice } from '../../service/classroom-service';
import { Classroom } from '../../types';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-classroom',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './view-classroom.html',   // ✅ Angular CLI convention
  styleUrls: ['./view-classroom.css']     // ✅ Angular CLI convention
})
export class ViewClassroom implements OnInit {

  message='hi';

  classrooms: Classroom[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private classroomService: Classroomservice,private cdr: ChangeDetectorRef,private router:Router) {}

  ngOnInit(): void {
    this.loadClassrooms();
  }

  loadClassrooms() {
  console.log("Loading Classrooms...");

  this.classroomService.getClassrooms().subscribe({
    next: (data) => {
      console.log(data)
      console.log("API Response: ", data, Array.isArray(data));
      
      this.classrooms = [];
      if (Array.isArray(data)) {
        console.log("inside if")
        data.forEach(item => {this.classrooms.push(item); console.log("pushing ")});
        this.cdr.detectChanges();

      }

      console.log("Assigned customers length:", this.classrooms.length);
    },
    error: (err) => {
      this.errorMessage = 'Failed to fetch data..';
      console.error(err);
    }
  });
}

deleteClassroom(id: number|undefined) {
  if(confirm('Are you sure to delete this classroom?')){
    this.classroomService.deleteClassroom(id).subscribe({
      next: () =>{
        alert('Classroom deleted successfully');
        this.loadClassrooms();
      },
      error:(err) =>{
        console.error(err);
        alert("Failed to delete a classroom");
      }
    })
  }
}
editClassroom(id: number|undefined) {
  console.log(" inside edit classroom")
  this.router.navigate(['/edit-classroom',id]);
}
onChange() {
  console.log(this.message);
}
}