import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-adminregister',
  templateUrl: './adminregister.component.html',
  styleUrls: ['./adminregister.component.css']
})
export class AdminregisterComponent implements OnInit {
  id;
  pass="";
  constructor(private _router:Router) { }

  ngOnInit() {
  }
  userlogin(){
    this._router.navigate(['/']);
  }
  login()
  {if(this.id=="admin" && this.pass=="admin123"){
    this._router.navigate(['/o']);
  }
  else{
    window.alert("Wrong credentials");
  }

  }
}
