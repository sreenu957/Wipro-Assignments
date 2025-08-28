import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { User } from "../types";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class Userservice{
  private apiUrl:string = "http://localhost:8081/api/users";
  constructor(private http:HttpClient){}
  addUser(user:any) : Observable<any>{
    return this.http.post(`${this.apiUrl}`,user);
  }
  getUsers() : Observable<User[]>{
    return this.http.get<User[]>(this.apiUrl);
  }
  deleteUser(id:number|undefined) : Observable<any>{
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
  getUserById(id:number) : Observable<any>{
    return this.http.get(`${this.apiUrl}/@{id}`);
  }
  UpdateUser(id:number,user:User):Observable<any>{
    return this.http.put(`${this.apiUrl}/${id}`,user);
  }
}