import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Assessmentservice } from '../../service/assessment-service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-assessment',
  imports: [FormsModule],
  templateUrl: './add-assessment.html',
  styleUrl: './add-assessment.css'
})
export class AddAssessment {

  assessment = {
    title: '',
    description:'',
    totalMarks:0,
    deadline:'',
    createdAt:''
  }
  message='';
  selectedCourseId!:number
  
  constructor(
    private assessmentService: Assessmentservice,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.selectedCourseId = Number(this.route.snapshot.paramMap.get('id'));
    console.log("Course ID from route:", this.selectedCourseId);
  }
  async onSubmit() {
    console.log("Submitting assessment:", this.assessment);
    const courseId= this.selectedCourseId;
    this.assessmentService.addAssessment(courseId, this.assessment).subscribe({
      next: (response) => {
        console.log("Assessment saved:", response);
        this.message = "Assessment added successfully!";
        this.router.navigate(['/assessments']);
      },
      error: (err) => {
        console.error("Error while saving assessment:", err);
        this.message = "Error adding assessment!";
      }
    });
  }
}