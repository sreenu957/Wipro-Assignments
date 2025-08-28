import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Assessment } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Assessmentservice } from '../../service/assessment-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-assessment',
  imports: [FormsModule],
  templateUrl: './edit-assessment.html',
  styleUrl: './edit-assessment.css'
})
export class EditAssessment implements OnInit{
assessment:Assessment = {
  id:0,
  title:'',
  description:'',
  totalMarks:0,
  deadline:'',
  createdAt:''
};
id!:number;
 constructor(private route:ActivatedRoute, private assessmentService:Assessmentservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from the url
    this.loadAssessment();
   
  }
  loadAssessment() {
    console.log(this.id);
    this.assessmentService.getAssessmentById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.assessment = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.assessmentService.updateAssessment(this.id, this.assessment).subscribe({
      next: () => {
        alert("Assessment updated successfully");
         this.router.navigate(['/assessments']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update assessment !");
      }
    })
}
  
} 