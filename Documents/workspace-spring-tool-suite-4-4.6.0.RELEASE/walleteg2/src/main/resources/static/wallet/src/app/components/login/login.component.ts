import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/shared_service/user.service';
import { User } from 'src/app/user';
import {Router, ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  user:User;
  private users:User[];
  un1:User;
  id;
  pass="";
  constructor(private _userService: UserService, private _router:Router,private route: ActivatedRoute) { }
  ngOnInit(){}
  
  login(){
  
    
    this._userService.getUserById(this.id)
      .subscribe(data => {
        console.log(data)
        this.un1 = data;
        if(this.un1.pass==this.pass && this.id==this.un1.id){
         // document.write("HELLO");
          this._router.navigate(['/userprofile',{id: this.id}]);
        }
        else{
          window.alert("Wrong Credentials. Retry!")
        }
      }, error => window.alert("Wrong Credentials. Retry!"));
      

    }
    adminlogin(){
      this._router.navigate(['/adminreg']);
    }
    register(){
      let user = new User;
      this._userService.setter(user);
      this._router.navigate(['/op']);

    }
}
