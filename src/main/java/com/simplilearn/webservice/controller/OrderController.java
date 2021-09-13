package com.simplilearn.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Order;
import com.simplilearn.webservice.repository.OrderRepository;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/orders")
	public List<Order> getOrders(){
		List<Order> orders = orderRepository.findAll();
		return orders;
	}
	
	@GetMapping("/orders/{id}")
	public Order getOneOrder(@PathVariable(value = "id") long id){
		Order order = orderRepository.findById(id).get();
		return order;
	}
	
	@PostMapping("/orders")
	public Order addOrder(@RequestBody Order orderObj){
		Order orders = orderRepository.save(orderObj);
		return orders;
	}
	
	@PutMapping("/orders/{id}")
	public Order updateOrder(@PathVariable(name = "id") long id, @RequestBody Order orderObj) {
		Order fetchOrder = orderRepository.findById(id).get();
		fetchOrder.setName(orderObj.getName());
		fetchOrder.setDateOfPurchase(orderObj.getDateOfPurchase());
		fetchOrder.setDescription(orderObj.getDescription());
		fetchOrder.setQuantity(orderObj.getQuantity());
		fetchOrder.setPrice(orderObj.getPrice());
		Order order = orderRepository.save(fetchOrder);
		return order;
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable(name = "id") long id) {
		Order order = orderRepository.findById(id).get();
		orderRepository.delete(order);
	}
}
