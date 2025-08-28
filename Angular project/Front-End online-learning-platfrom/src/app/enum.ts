export enum Role{
    STUDENT,
    TEACHER,
    ADMIN
}
function checkAccess(role:Role):string{
    switch(role){
        case Role.STUDENT:
            return "Limited access";
        case Role.TEACHER:
            return "Guest access only";
        case Role.ADMIN:
            return "Full access granted";
        default:
            return "No access";
    }
}

console.log(checkAccess(Role.ADMIN));
console.log(checkAccess(Role.TEACHER));