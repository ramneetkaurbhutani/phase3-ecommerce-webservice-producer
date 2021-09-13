package com.simplilearn.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private long id;
	
	@Column(name = "payment_method")
	private String method;
	
	@Column(name = "payment_date")
	private Date date;

	public Payment(long id, String method, Date date) {
		super();
		this.id = id;
		this.method = method;
		this.date = date;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", method=" + method + ", date=" + date + "]";
	}
	
	
	
}
