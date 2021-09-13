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

import com.simplilearn.webservice.entity.Product;
import com.simplilearn.webservice.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		List<Product> products = productRepository.findAll();
		return products;		
	}
	
	@GetMapping("/products/{id}")
	public Product getOneProduct(@PathVariable(value = "id") long id ) {
		
		Product product = productRepository.findById(id).get();
		return product;
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product productObj){
		Product product = productRepository.save(productObj);
		return product;
	}
	
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value = "id") long id, @RequestBody Product productObj ) {
		//Find a product
		Product fetchProduct = productRepository.findById(id).get();
		//Set all updating fields
		fetchProduct.setName(productObj.getName());
		fetchProduct.setDescription(productObj.getDescription());
		fetchProduct.setPrice(productObj.getPrice());
		Product product = productRepository.save(fetchProduct);
		return product;
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable(value = "id") long id) {
		Product fetchProduct = productRepository.findById(id).get();
		productRepository.delete(fetchProduct);
	}
}
