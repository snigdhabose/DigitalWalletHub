import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient, HttpResponse, HttpHeaders, HttpRequest} from '@angular/common/http';
import { User } from '../user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl:string="http://localhost:3037/api/user";
  //private headers=new Headers({'Content-Type':'application/json'});
  //private options=new RequestOptions({headers:this.headers});
  //private options=HttpRequest{headers:this.headers};
  private user:User;
  constructor(private http : HttpClient) { }


   getUserById(id:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  } 
  
  getAllUsers(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  } 
  updateUser(id: number, user:User): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
 setter(user:User)
 {
   this.user=user;
 }
 getter()
 {
   return this.user;
 }
 createUser(user: User): Observable<Object> {
  return this.http.post(`${this.baseUrl}`, user);
}
 
}
  /** getUsers(){
    return this.http.get(this.baseUrl+'/users').
    map((response:Response)=>response.json())
    .catch(this.errorHandler);
  }
  errorHandler(error:Response){
    return Observable.throw(error||"SERVER ERROR");
    
  }  
 
/* getAllUsers():Observable<User[]>{
  return this.http.get<User[]>('http://localhost:3037/api').
  pipe(
    map((data: User[])=>{
      return data;
    }), catchError(error => {
      console.error(error);
      return Observable.throw(error);
    })
}
 */
