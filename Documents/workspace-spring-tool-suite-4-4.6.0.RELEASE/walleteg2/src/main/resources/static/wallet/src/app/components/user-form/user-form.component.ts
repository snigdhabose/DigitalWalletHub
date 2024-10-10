import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user';
import {Router} from '@angular/router';
import { UserService } from 'src/app/shared_service/user.service';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  user:User;
  un:User;
  constructor(private _userService: UserService, private _router:Router) { }

  ngOnInit() {
    this.user=this._userService.getter();
  }
  logout(){
    this._router.navigate(['/']);
  }
  processForm(){
    if(this.user.id==undefined){
      this._userService.createUser(this.user).subscribe((user)=>{
        console.log(this.user);
        this._router.navigate(['/o']);
      },(error)=>{
        console.log(error);
      });
     }else{
      this._userService.updateUser(this.user.id,this.user).subscribe((user)=>{
        console.log(user);
        this._router.navigate(['/o']);
      },(error)=>{
        console.log(error);
      });
  }
 
}
}