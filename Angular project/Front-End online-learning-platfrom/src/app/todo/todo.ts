import { CommonModule } from '@angular/common';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo',
  imports: [CommonModule],
  templateUrl: './todo.html',
  styleUrl: './todo.css'
})
export class Todo implements OnInit{

  todos:any[]=[];
  statusCode:number | null = null;

  constructor(private http:HttpClient,private cdr:ChangeDetectorRef){}

ngOnInit(): void {
  
  this.loadTodos();
 
}
  loadTodos() {
    this.http.get<any[]>('https://jsonplaceholder.typicode.com/todos', {observe:'response'}).subscribe({
      next:(res:HttpResponse<any[]>)=>{
        this.statusCode = res.status;
        this.todos= res.body|| [];
        console.log(this.statusCode);
        console.log(this.todos);
        console.log("response headers "+res.headers.keys());
 this.cdr.detectChanges();
      },
      error:(err)=>{
        this.statusCode= err.status;
        console.error(err);
      },
      complete:()=>{
        console.log(" Request is completed");
      }
    })
  }

}