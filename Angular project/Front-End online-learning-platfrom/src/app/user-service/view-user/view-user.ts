import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Userservice } from '../../service/userservice';
import { User } from '../../types';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-user',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-user.html',   // ✅ Angular CLI convention
  styleUrls: ['./view-user.css']     // ✅ Angular CLI convention
})
export class ViewUser implements OnInit {

  users: User[] = [];
  errorMessage = '';
  isLoading = true;

  constructor(private userService: Userservice,private cdr: ChangeDetectorRef,private router:Router) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers() {
  console.log("Loading Users...");

  this.userService.getUsers().subscribe({
    next: (data) => {
      console.log("API Response: ", data, Array.isArray(data));
      
      this.users = [];
      if (Array.isArray(data)) {
        console.log("inside if")
        data.forEach(item => {this.users.push(item); console.log("pushing ")});
        this.cdr.detectChanges();

      }

      console.log("Assigned users length:", this.users.length);
    },
    error: (err) => {
      this.errorMessage = 'Failed to fetch data..';
      console.error(err);
    }
  });
}

deleteUser(id: number|undefined) {
  if(confirm('ARe you sure to delete this user?')){
    this.userService.deleteUser(id).subscribe({
      next: () =>{
        alert('User deleted successfully');
        this.loadUsers();
      },
      error:(err) =>{
        console.error(err);
        alert("Failed to delete a user");
      }
    })
  }
}
editUser(id: number|undefined) {
  console.log(" inside edit user")
  this.router.navigate(['/edit-user',id]);
}
}