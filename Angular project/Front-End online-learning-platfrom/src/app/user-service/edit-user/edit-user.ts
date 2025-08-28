import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../../types';
import { ActivatedRoute, Router } from '@angular/router';
import { Userservice } from '../../service/userservice';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Role } from '../../enum';

@Component({
  selector: 'app-edit-user',
  imports: [FormsModule, CommonModule],
  templateUrl: './edit-user.html',
  styleUrl: './edit-user.css'
})
export class EditUser implements OnInit{
user:User = {
  id:0,
  name:'',
  email:'',
  password:'',
  role: Role.TEACHER
};
id!:number;
 constructor(private route:ActivatedRoute, private userService:Userservice,private router:Router,private cdr: ChangeDetectorRef){}


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; //get id from the url
    this.loadUser();
   
  }
  loadUser() {
    console.log(this.id);
    this.userService.getUserById(this.id).subscribe({
      next: (data)=>{
        console.log(data);
        this.user = data;
        this.cdr.detectChanges();
      },
      error:(err)=>console.error(err)
    });
  }
  onSubmit() {
    this.userService.UpdateUser(this.id, this.user).subscribe({
      next: () => {
        alert("User updated successfully");
         this.router.navigate(['/user']);
      },
      error: (err)=>{
        console.error(err);
        alert("Failed to update user !");
      }
    })
} 
}