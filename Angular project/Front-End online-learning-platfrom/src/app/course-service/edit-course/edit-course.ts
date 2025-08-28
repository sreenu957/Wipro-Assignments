import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Courseservice } from '../../service/course-service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-course',
  imports: [FormsModule, CommonModule],
  templateUrl: './edit-course.html',
  styleUrl: './edit-course.css'
})
export class EditCourse implements OnInit{
course = {
    title: '',
    description: '',
    duration: '',
    createdAt: ''
};
id!:number;
 constructor(private route:ActivatedRoute, private courseService:Courseservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from the url
    this.loadCourse();
   
  }
  loadCourse() {
    console.log(this.id);
    this.courseService.getCourseById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.course = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.courseService.updateCourse(this.id, this.course).subscribe({
      next: () => {
        alert("Course updated successfully");
         this.router.navigate(['/course']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update course !");
      }
    })
} 
}