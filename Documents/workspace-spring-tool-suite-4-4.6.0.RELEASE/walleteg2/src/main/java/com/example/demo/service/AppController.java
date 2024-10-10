package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Transaction;
import com.example.demo.models.UserD;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class AppController {
	@Autowired
	UserService serv1;
	@Autowired
	TransactionService serv2;
	
	
	
	/**@RequestMapping("/user/{id}")
	public UserD getUser(@PathVariable int id) {
		return serv1.getOne(id);
	}
	@RequestMapping("/transaction/{txnid}")
	public Transaction getTransaction(@PathVariable int txnid) {
		return serv2.getOne(txnid);
	}**/
	@GetMapping("/user")
    public List<UserD> getAllUsers() {
        return serv1.findAll();
    }
	@GetMapping("/user/{id}")
    public ResponseEntity<UserD> getUserById(@PathVariable(value = "id") int Id){
		
        UserD u1 = serv1.getOne(Id);
        return ResponseEntity.ok().body(u1);
    }
	
	@GetMapping("/user/trans/{id}")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable(value = "id") int Id) {
        UserD u1 = serv1.getOne(Id);
        List<Transaction> t=new ArrayList<Transaction>();
        t=u1.getTransactions();
        return ResponseEntity.ok().body(t);
    }
	 @PostMapping("/user")
	    public UserD createUser(@Valid @RequestBody UserD u1) {
	        return serv1.save(u1);
	    }
	 @PostMapping("/user/trans")
	    public Transaction createTrans(@Valid @RequestBody Transaction t,double amt) {
		 	Transaction t1=new Transaction(t.getAccNo(),t.getBalance()+amt);
		 	t1.setUser(t.getUser());
	        return serv2.save(t1);
	    }
	
	    @PutMapping("/user/{id}")
	    public ResponseEntity<UserD> updateUser(@PathVariable(value = "id") int Id,
	         @Valid @RequestBody UserD userDetails)  {
	         UserD u1 = serv1.getOne(Id);
	         u1.setName(userDetails.getName());
	         u1.setEmail(userDetails.getEmail());
	         u1.setPass(userDetails.getPass());
	         u1.setPno(userDetails.getPno());
	        final UserD updatedUser = serv1.save(u1);
	        return ResponseEntity.ok(updatedUser);
	    }
	    @PutMapping("/user/trans/{id}")
	    public ResponseEntity<Transaction> updateBal(@PathVariable(value = "id") int Id,
	        @Valid @RequestBody Transaction trans )  {
	    	Transaction t1=new Transaction(trans.getAccNo(),trans.getBalance());
	    	t1.setBalance(trans.getBalance());
	         UserD u1 = serv1.getOne(Id);
	         t1.setUser(u1);
	         t1.setTransType(trans.getTransType());
	        u1.getTransactions().add(t1);
	        serv1.save(u1);
	        final Transaction updatedTrans=serv2.save(t1);
	        //return serv2.save(t);
	        return ResponseEntity.ok(updatedTrans);
	        
	       
	    }
	   

	    @DeleteMapping("/user/{id}")
	    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int Id){
	        UserD u1 = serv1.getOne(Id);
	        serv1.delete(u1);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
}
