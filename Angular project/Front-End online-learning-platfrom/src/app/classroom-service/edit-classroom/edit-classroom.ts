import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Classroom } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Classroomservice } from '../../service/classroom-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-classroom',
  imports: [FormsModule],
  templateUrl: './edit-classroom.html',
  styleUrl: './edit-classroom.css'
})
export class EditClassroom implements OnInit{
classroom:Classroom = {
  id:0,
  name:'',
  location:'',
  capacity:0,
  type:''
};
id!:number;
 constructor(private route:ActivatedRoute, private classroomService:Classroomservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from the url
    this.loadClassroom();
   
  }
  loadClassroom() {
    console.log(this.id);
    this.classroomService.getClassroomById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.classroom = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.classroomService.updateClassroom(this.id, this.classroom).subscribe({
      next: () => {
        alert("Classroom updated successfully");
         this.router.navigate(['/classroom']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update classroom !");
      }
    })
}
  
} 