import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute, ParamMap} from '@angular/router';
import { UserService } from 'src/app/shared_service/user.service';
import { User } from 'src/app/user';
import { HttpParams } from '@angular/common/http';
import { Transaction } from 'src/app/transaction';
import { TransactionService } from 'src/app/shared_service/transaction.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css']
})
export class UserprofileComponent implements OnInit {
  selectedid;
  user:User;
  amt;
  private t1:Transaction;
  trans:Transaction[];
  constructor(private _userService: UserService, private _router:Router,private route: ActivatedRoute, 
    private _transaction:TransactionService) { }

  ngOnInit(){
    this.route.paramMap.subscribe((HttpParams: ParamMap)=>{
      let id=parseInt(HttpParams.get('id'));
      this.selectedid=id;

      this._userService.getUserById(this.selectedid)
      .subscribe(data => {
        console.log(data)
        this.user = data;
        console.log(this.user);
      }, error =>window.alert("Try Again"));
    })
    this._transaction.getTransactions(this.selectedid)
    .subscribe(data => {
      console.log(data)
      this.trans = data;
    }, error => window.alert("No Transactions to show!"));
  }
  update(user){
    
      this._userService.setter(user);
      this._router.navigate(['/']);
      
    
  }
  Withdraw(){
    this.t1=this.trans.pop();
    this.trans.push(this.t1);
    if((this.t1.balance - this.amt)>0){
    this.t1.balance=this.t1.balance - this.amt;
    this.t1.transType="Withdraw";
    this._transaction.updateBal(this.user.id,this.t1).subscribe((t1)=>{
      console.log(this.t1);
      this.trans.push(this.t1);
      this._transaction.getTransactions(this.selectedid)
    .subscribe(data => {
      console.log(data)
      this.trans = data;
    }, error => window.alert("No Transactions to show!"));
     
    },(error)=>{
      console.log(error);
    });
    
  }
  else{
    window.alert("Balance low!");
  }
    
  }
  logout(){
    this._router.navigate(['/']);
  }
  Deposit(){
    
    this.t1=this.trans.pop();
    this.trans.push(this.t1);
    this.t1.balance=this.t1.balance + this.amt;
    this.t1.transType="Deposit";
    this._transaction.updateBal(this.user.id,this.t1).subscribe((t1)=>{
      console.log(this.t1);
     
      //this.trans.push(this.t1);
     // this._router.navigate(['/userprofile',{id: this.selectedid}]);
     this._transaction.getTransactions(this.selectedid)
    .subscribe(data => {
      console.log(data)
      this.trans = data;
    }, error => window.alert("No Transactions to show!"));
     
    },(error)=>{
      console.log(error);
    });
    
    
    
  }
  
  

}
