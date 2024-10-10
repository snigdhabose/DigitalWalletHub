import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import {RouterModule, Routes } from '@angular/router';
import { UserService } from './shared_service/user.service';
import { LoginComponent } from './components/login/login.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { AdminregisterComponent } from './components/adminregister/adminregister.component';
import { NewuserComponent } from './components/newuser/newuser.component';


const appRoutes:Routes=[
  {path:'',component:LoginComponent},
  {path:'o',component:ListuserComponent},
  {path:'op',component:UserFormComponent},
  {path:'userprofile',component:UserprofileComponent},
  {path:'adminreg',component:AdminregisterComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    LoginComponent,
    UserprofileComponent,
    AdminregisterComponent,
    NewuserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
