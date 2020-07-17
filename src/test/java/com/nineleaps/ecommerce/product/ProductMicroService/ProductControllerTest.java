package com.nineleaps.ecommerce.product.ProductMicroService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nineleaps.ecommerce.product.beans.Product;
import com.nineleaps.ecommerce.product.beans.ProductResponse;
import com.nineleaps.ecommerce.product.beans.Supplier;
import com.nineleaps.ecommerce.product.controller.ProductController;
import com.nineleaps.ecommerce.product.entity.ProductEntity;
import com.nineleaps.ecommerce.product.service.ProductService;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	ProductController productController;

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;

	@MockBean
	Product product;

	@MockBean
	ProductResponse productResponse;

	@BeforeEach
	void setupThis() {
		System.out.println("@BeforeEach executed");
	}
	Product productStub = new Product("P1","Pname1","100","Desc1", "S1");
	Supplier supplier = new Supplier("S1","Sname1","S1email@xyz.com");
	
	@Test
	public void testCreateProductSuccess() throws Exception {

		//Product productStub = new Product("P1","Pname1","100","Desc1", "S1");
		//Supplier supplier = new Supplier("S1","Sname1","S1email@xyz.com");
		when(productService.checkSupplierPresent(any(Product.class))).thenReturn(supplier);
		
		ProductEntity productEntity = new ProductEntity("P1","Pname1","100","Desc1", "S1");
		when(productService.createProduct(any(Product.class))).thenReturn(productEntity);
		
		mockMvc.perform(post("/product/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString((productStub))))
				.andExpect(status().isCreated());
	}	

	@Test
	public void testCreateProductFailure() throws Exception {

		//Product productStub = new Product("P1","Pname1","100","Desc1", "S1");
		Supplier supplier = null;
		when(productService.checkSupplierPresent(any(Product.class))).thenReturn(supplier);
		
		ProductEntity productEntity = new ProductEntity("P1","Pname1","100","Desc1", "S1");
		when(productService.createProduct(any(Product.class))).thenReturn(productEntity);
		
		mockMvc.perform(post("/product/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString((productStub))))
				.andExpect(status().isNotFound());
	}	
	
	@Test
	public void testGetProductSuccess() throws Exception {

	//	Product productStub = new Product("P1","Pname1","100","Desc1", "S1");
		when(productService.getProductFromDB(anyString())).thenReturn(productStub);
		
		mockMvc.perform(get("/product/getProduct/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}	
	
	@Test
	public void testGetProductFailure() throws Exception {

		Product productStub = null;
		when(productService.getProductFromDB(anyString())).thenReturn(productStub);
		
		mockMvc.perform(get("/product/getProduct/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}	
	
	@Test
	public void testUpdateProductSuccess() throws Exception {

		//Product productStub = null;
		when(productService.updateProductDetails(anyString(),any(Product.class))).thenReturn(productStub);
		mockMvc.perform(put("/product/updateProduct/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString((productStub))))
				.andExpect(status().isOk());
	}	
	
	
	@Test 
	public void testUpdateProductFailure() throws Exception {
	  
	//Product productStub = null;
	    when(productService.updateProductDetails(anyString(),any(Product.class))).thenReturn(""); 
		mockMvc.perform(put("/product/updateProduct/1")
		.contentType(MediaType.APPLICATION_JSON) 
		.content(asJsonString((productStub))))
		.andExpect(status().isNotFound());
	}
	
	
	@Test
	public void testDeleteProductSuccess() throws Exception {

		//Product productStub = null;
		mockMvc.perform(delete("/product/deleteProduct/1"))
				.andExpect(status().isOk());
	}	
	
	
	@Test
	public void testGetAllProductsSuccess() throws Exception {
		ProductEntity productStub = new ProductEntity("P1","Pname1","100","Desc1", "S1");
		List<ProductEntity> products = new ArrayList<ProductEntity>();
		products.add(productStub);
		when(productService.getallProductDetails()).thenReturn(products);
		mockMvc.perform(get("/product/viewProducts"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void testGetAllProductsFailure() throws Exception {
		ProductEntity productStub = new ProductEntity("P1","Pname1","100","Desc1", "S1");
		List<ProductEntity> products = null ;
		when(productService.getallProductDetails()).thenReturn(products);
		mockMvc.perform(get("/product/viewProducts"))
				.andExpect(status().isNoContent());
	}
		
//		ResponseEntity<?> result = productController.createProduct(productStub); 
		
//		String mockSupplierJson = JsonConstants.mockSupplierJson;
//		String mockProductJson = JsonConstants.mockProductJson;
//
//		ObjectMapper mapper = new ObjectMapper();
//		Supplier supplier = mapper.readValue(mockSupplierJson, Supplier.class);
//		Product product = mapper.readValue(mockProductJson, Product.class);
//
//		mockProductService = Mockito.mock(ProductService.class);
//
//		when(mockProductService.saveIfSupplierAvailable(product)).thenReturn(supplier);
//
//		productResult = productService.saveIntoProductTable(product);
//
//		assertEquals(productResult.getSupplierId(), product.getSupplierId());

//	//@Test public void testCreateProduct(){ 
//		Product product = new Product();
//  Supplier supplier = new Supplier(); //
//  Mockito.when(productService.checkSupplierPresent((Product)Mockito.any())).
//  thenReturn(supplier);
//  Mockito.when(productService.checkSupplierPresent(Mockito.any(Product.class)))
//  .thenReturn(supplier);
//  
//  // ProductEntity productEntity = new ProductEntity(); //
//  Mockito.when(productService.createProduct((Product)Mockito.any())).thenReturn
//  (productEntity); // ResponseEntity<?> responseEntity =
//  Mockito.when(methodCall)
//  
//  ResponseEntity<?> result = productController.createProduct(product); 
	
	 static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
