package com.example.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders="*")
public class UserD {
	
	@Id
	@GeneratedValue
    @Column(name = "ID")
	private int id;
	@Column(name = "PASSWORD",unique=true)
	private String pass;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL",unique=true)
	private String email;
	@Column(name = "ACCOUNTNO",unique=true)
	private long accountNo;
	
	@Column(name = "CUSTID",unique=true)
	private String custid;
	@Column(name = "PHONENO",unique=true)
	private String pno;
	@OneToMany(cascade=CascadeType.ALL)
	@JsonManagedReference
    @JoinTable(joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="txn_id"))
    private List<Transaction> transactions=new ArrayList<Transaction>();
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + ", accountNo=" + accountNo
				+ ", custid=" + custid + ", pno=" + pno + ", transactions=" + transactions + "]";
	}
	public UserD( String custid,String pass, String name, String email, long accountNo, String pno) {
		super();
		this.custid=custid;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.accountNo = accountNo;
		this.pno = pno;
	}
	public UserD() {
		super();
		// TODO Auto-generated constructor stub
	}


}
