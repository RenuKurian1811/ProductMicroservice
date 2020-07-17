package com.nineleaps.ecommerce.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nineleaps.ecommerce.product.beans.Product;
import com.nineleaps.ecommerce.product.beans.ProductResponse;
import com.nineleaps.ecommerce.product.beans.Supplier;
import com.nineleaps.ecommerce.product.entity.ProductEntity;
import com.nineleaps.ecommerce.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductResponse productResponse;
	
	@PostMapping("/create")
	public	ResponseEntity<?> createProduct(@RequestBody Product product){
		Supplier prodSupplier = productService.checkSupplierPresent(product); 
		ResponseEntity<?> responseEntity = null;
		if( null != prodSupplier) {
			responseEntity = new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
		}   
		else {
			productResponse.setCode("404");
			productResponse.setMessage("Supplier Not Available");
			responseEntity = new ResponseEntity<>(productResponse, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
		
	}
	
	@GetMapping(path = "/getProduct/{id}")
	ResponseEntity<?> getProduct(@PathVariable("id") String pId){
		ResponseEntity<?> responseEntity = null;
		try {
			product = productService.getProductFromDB(pId);
			if( null != product) {
				responseEntity =  new ResponseEntity<>(product,HttpStatus.OK);
			}
			else {
				productResponse.setCode("404");
				productResponse.setMessage("Product Not Available");
				responseEntity = new ResponseEntity<>(productResponse ,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity; 
	}

	@PutMapping(path = "/updateProduct/{id}")
	ResponseEntity<?> updateProduct(@PathVariable("id") String pId, @RequestBody Product newProduct){
		ResponseEntity<?> responseEntity = null;
		try {
			Object response =  productService.updateProductDetails(pId,newProduct);
			if(response instanceof Product) {
				responseEntity =  new ResponseEntity<>(response,HttpStatus.OK);
			}
			else {
				responseEntity =  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") String pId) {
		try {
			productService.deleteProductDetails(pId);
			productResponse.setCode("200");
			productResponse.setMessage("Deleted");
			return new ResponseEntity<>(productResponse,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/viewProducts")
	public ResponseEntity<List<ProductEntity>> getAllProducts() {
		try {
			List<ProductEntity> products;
			products = productService.getallProductDetails();
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
