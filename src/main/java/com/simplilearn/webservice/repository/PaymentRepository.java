package com.simplilearn.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
