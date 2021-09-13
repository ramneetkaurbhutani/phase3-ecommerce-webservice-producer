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

import com.simplilearn.webservice.entity.Payment;
import com.simplilearn.webservice.repository.PaymentRepository;

@RestController
@RequestMapping("/api")
public class PaymentController {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@GetMapping("/payments")
	public List<Payment> getPayments(){
		List<Payment> payments = paymentRepository.findAll();
		return payments;
	}
	
	@GetMapping("/payments/{id}")
	public Payment getOnePayment(@PathVariable(name = "id")long id){
		Payment payment = paymentRepository.findById(id).get();
		return payment;
	}
	
	@PostMapping("/payments")
	public Payment addPayment(@RequestBody Payment paymentObj){
		Payment payment = paymentRepository.save(paymentObj);
		return payment;
	}
	
	@PutMapping("/payments/{id}")
	public Payment updatePayment(@PathVariable(name = "id")long id, @RequestBody Payment paymentobj){
		Payment fetchPayment = paymentRepository.findById(id).get();
		fetchPayment.setMethod(paymentobj.getMethod());
		fetchPayment.setDate(paymentobj.getDate());
		Payment payment = paymentRepository.save(fetchPayment);
		return payment;
	}
	
	@DeleteMapping("/payments/{id}")
	public void deletePayment(@PathVariable(name = "id") long id) {
		Payment payment = paymentRepository.findById(id).get();
		paymentRepository.delete(payment);
	}
}
