import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Courseservice } from '../../service/course-service';
import { Course } from '../../types';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-course',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-course.html',   // ✅ Angular CLI convention
  styleUrls: ['./view-course.css']     // ✅ Angular CLI convention
})
export class ViewCourse implements OnInit {

  courses: Course[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private courseService: Courseservice,private cdr: ChangeDetectorRef,private router:Router) {}

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses() {
  console.log("Loading Courses...");

  this.courseService.getCourses().subscribe({
    next: (data) => {
      console.log("API Response: ", data, Array.isArray(data));
      
      this.courses = [];
      if (Array.isArray(data)) {
        console.log("inside if")
        data.forEach(item => {this.courses.push(item); console.log("pushing ")});
        this.cdr.detectChanges();

      }

      console.log("Assigned courses length:", this.courses.length);
    },
    error: (err) => {
      this.errorMessage = 'Failed to fetch data..';
      console.error(err);
    }
  });
}

deleteCourse(id: number|undefined) {
  if (!id) return;

  if(confirm('Are you sure to delete this course?')){
    this.courseService.deleteCourse(id).subscribe({
      next: () => {
        alert('Course deleted successfully');
        // Remove deleted course from local array
        this.courses = this.courses.filter(course => course.id !== id);
      },
      error:(err) =>{
        console.error(err);
        alert("Failed to delete the course");
      }
    });
  }
}
editCourse(id: number|undefined) {
  console.log(" inside edit course")
  this.router.navigate(['/edit-course',id]);
}
}