import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Assessmentservice } from '../../service/assessment-service';
import { Assessment } from '../../types';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-assessment',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './view-assessment.html',   // ✅ Angular CLI convention
  styleUrls: ['./view-assessment.css']     // ✅ Angular CLI convention
})
export class ViewAssessment implements OnInit {

  message='hi';

  assessments: Assessment[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private assessmentService: Assessmentservice,private cdr: ChangeDetectorRef,private router:Router) {}

  ngOnInit(): void {
    this.loadAssessments();
  }

  loadAssessments() {
  console.log("Loading Assessments...");

  this.assessmentService.getAssessments().subscribe({
    next: (data) => {
      console.log(data)
      console.log("API Response: ", data, Array.isArray(data));
      
      this.assessments = [];
      if (Array.isArray(data)) {
        console.log("inside if")
        data.forEach(item => {this.assessments.push(item); console.log("pushing ")});
        this.cdr.detectChanges();

      }

      console.log("Assigned assessments length:", this.assessments.length);
    },
    error: (err) => {
      this.errorMessage = 'Failed to fetch data..';
      console.error(err);
    }
  });
}

deleteAssessment(id: number|undefined) {
  if(confirm('Are you sure to delete this assessment?')){
    this.assessmentService.deleteAssessment(id).subscribe({
      next: () =>{
        alert('Assessment deleted successfully');
        this.loadAssessments();
      },
      error:(err) =>{
        console.error(err);
        alert("Failed to delete a assessment");
      }
    })
  }
}
editAssessment(id: number|undefined) {
  console.log(" inside edit assessment")
  this.router.navigate(['/edit-assessment',id]);
}
onChange() {
  console.log(this.message);
}
}