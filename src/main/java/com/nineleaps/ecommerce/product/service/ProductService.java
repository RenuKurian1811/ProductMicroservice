package com.nineleaps.ecommerce.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nineleaps.ecommerce.product.beans.Product;
import com.nineleaps.ecommerce.product.beans.ProductResponse;
import com.nineleaps.ecommerce.product.beans.Supplier;
import com.nineleaps.ecommerce.product.controller.FeignController;
import com.nineleaps.ecommerce.product.entity.ProductEntity;
import com.nineleaps.ecommerce.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired(required = true)
	private FeignController feignController;
	
	
	/*
	 * public String createProduct(Product product) { productRepository.save(new
	 * ProductEntity(product.getProductId(), product.getName(), product.getPrice(),
	 * product.getDescription(), product.getSupplierId())); return null; }
	 */

	public ProductEntity createProduct(Product product) {
		ProductEntity savedProduct = productRepository.save(mapObjectToEntity(product));
		return savedProduct;
	}
	
	public Product getProductFromDB(String pId) throws Exception {
		Optional<ProductEntity> productEntity = productRepository.findById(pId);
		if(!productEntity.isPresent()) {
			return null;
		}
		return mapEntityToObject(productEntity.get());
	}
	
	public Object updateProductDetails(String pId, Product newProduct) throws Exception {
		ProductResponse productResponse = new ProductResponse();
		Optional<ProductEntity> productPresent = productRepository.findById(pId);
		Product updatedProduct = null;
		if(!productPresent.isPresent()) {
			productResponse.setCode("404");
			productResponse.setMessage("No Existing Record found!");
			return productResponse;
		}
		else {
			updatedProduct = updateRecordIntoDB(pId,newProduct);
			return updatedProduct;	
		}
		
	}

	private Product updateRecordIntoDB(String pId,Product newProduct) {
		productRepository.deleteById(pId);
		ProductEntity productEntity = productRepository.save(mapObjectToEntity(newProduct));
		return mapEntityToObject(productEntity);		
	}
	
	private ProductEntity mapObjectToEntity(Product product) {

		ProductEntity entity = new ProductEntity();
		entity.setProductId(product.getProductId());
		entity.setDescription(product.getDescription());
		entity.setName(product.getName());
		entity.setPrice(product.getPrice());
		entity.setSupplierId(product.getSupplierId());

		return entity;
	}
	
	private Product mapEntityToObject(ProductEntity productEntity) {
		Product object = new Product();
		object.setProductId(productEntity.getProductId());
		object.setName(productEntity.getName());
		object.setPrice(productEntity.getPrice());
		object.setDescription(productEntity.getDescription());
		object.setSupplierId(productEntity.getSupplierId());
		return object;
	}

	public Integer deleteProductDetails(String pId) {
		try {
			productRepository.deleteById(pId);
			return 0;
		}
		catch(Exception e){
			throw e;
		}
	}

	public List<ProductEntity> getallProductDetails() {
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	public Supplier checkSupplierPresent(Product product) {
		Supplier supplier = feignController.checkSupplierAvailability(product.getSupplierId());
		return supplier;
	}

}
