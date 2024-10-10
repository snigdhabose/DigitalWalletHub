import { Transaction } from './transaction';

export class User {
    id:number;
    name:string;
    email:string;
    pno:string;
    accountNo:number;
    pass:string;
    custid:string;
    
    User(id,name,email,pno,pass){
        this.id=id;
        this.name=name;
        this.pass=pass;
        this.email=email;
        
    }
}
