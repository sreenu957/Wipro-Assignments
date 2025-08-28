import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Course } from "../types";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class Courseservice {
  private apiUrl: string = "http://localhost:8082/api/courses";

  // Test credentials (make sure they match backend config)
  private username = 'admin';
  private password = 'admin123';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const basicAuth = 'Basic ' + btoa(this.username + ':' + this.password);
    return new HttpHeaders({
      Authorization: basicAuth,
      'Content-Type': 'application/json'
    });
  }

  addCourse(course: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, course, { headers: this.getAuthHeaders() });
  }

  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  deleteCourse(id: number | undefined): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  getCourseById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  updateCourse(id: number, course: Course): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, course, { headers: this.getAuthHeaders() });
  }
}