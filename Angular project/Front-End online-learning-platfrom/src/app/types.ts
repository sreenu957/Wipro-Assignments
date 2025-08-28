import { Role } from "./enum";

export interface User{
    id?:number,
    name:string,
    email:string,
    password:string,
    role: Role
}

export interface Course{
    id?: number,
    title: string,
    description: string,
    duration: string,
    createdAt: string
}

export interface Classroom{
    id?:number,
    name:string,
    location:string,
    capacity:number,
    type:string
}

export interface Assessment{
    id?:number,
    title:string,
    description:string,
    totalMarks:number,
    deadline:string,
    createdAt:string
}