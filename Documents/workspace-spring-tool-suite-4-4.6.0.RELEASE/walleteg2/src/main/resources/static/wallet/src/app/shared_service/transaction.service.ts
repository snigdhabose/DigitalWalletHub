import { Injectable } from '@angular/core';
import { Transaction } from '../transaction';
import {HttpClient, HttpResponse, HttpHeaders, HttpRequest} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/user';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private baseUrl:string="http://localhost:3037/api/user/trans";
  private trans:Transaction;
  constructor(private http : HttpClient) { }


  getTransactions(id:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  } 
  
  updateBal(id: number, trans:Transaction): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, trans);
  }
 
  /* createTrans(trans :Transaction,amt:number ): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, trans);
  } */
  setter(trans:Transaction)
 {
   this.trans=trans;
 }
 getter()
 {
   return this.trans;
 }
}
