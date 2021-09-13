package com.simplilearn.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "order_id")
	private long id;
	
	@Column(name = "order_name")
	private String name;
	
	@Column(name = "order_description")
	private String description;
	
	@Column(name = "order_date")
	private Date dateOfPurchase;
	
	@Column(name = "order_quantity")
	private int quantity;
	
	@Column(name = "order_price")
	private double price;

	public Order(long id, String name, String description, Date dateOfPurchase, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateOfPurchase = dateOfPurchase;
		this.quantity = quantity;
		this.price = price;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price * quantity;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", description=" + description + ", dateOfPurchase="
				+ dateOfPurchase + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
