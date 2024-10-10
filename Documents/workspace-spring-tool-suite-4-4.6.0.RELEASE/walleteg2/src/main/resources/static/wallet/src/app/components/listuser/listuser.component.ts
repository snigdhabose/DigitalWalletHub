import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user';
import { UserService } from 'src/app/shared_service/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.css']
})
export class ListuserComponent implements OnInit {
  users:User[];
  
  constructor(private _userService : UserService, private _router:Router ) { }

  ngOnInit(){
    this._userService.getAllUsers().subscribe((users)=>{
      console.log(users);
      this.users=users;
    },(error)=>{
      console.log(error);
    })
  }
 delete(user)
{
    this._userService.deleteUser(user.id).subscribe((data)=>{
      this.users.splice(this.users.indexOf(user),1);
    },(error)=>{
      console.log(error)
    })
}
update(user){
  this._userService.setter(user);
  this._router.navigate(['/op']);
}
newUser(){
  let user = new User;
  this._userService.setter(user);
  this._router.navigate(['/op']);
}
logout(){
  this._router.navigate(['/']);
}
}