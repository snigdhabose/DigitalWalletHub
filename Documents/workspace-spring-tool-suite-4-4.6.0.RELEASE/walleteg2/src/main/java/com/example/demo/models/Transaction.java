package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="transactions")
public class Transaction  {
	
	
	@Id
	@GeneratedValue
	@Column(name = "TRANSACTIONID")
	private int txnid;
	@Column(name = "ACCOUNTNO")
	private long accNo;
	@Column(name = "BALANCE")
	private double balance;
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name="user_id")
	private UserD user;
	public UserD getUser() {
		return user;
	}
	public void setUser(UserD user) {
		this.user = user;
	}
	private String transType;
	public int getTxnid() {
		return txnid;
	}
	public void setTxnid(int txnid) {
		this.txnid = txnid;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	@Override
	public String toString() {
		return "Transaction [txnid=" + txnid + ", accNo=" + accNo + ", balance=" + balance 
				 + "]";
	}
	public Transaction( long accNo, double balance) {
		super();
		
		this.accNo = accNo;
		this.balance = balance;
	
		
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

}
