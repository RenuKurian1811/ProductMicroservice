//package com.nineleaps.ecommerce.product.ProductMicroService;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.cassandraunit.spring.CassandraDataSet;
//import org.cassandraunit.spring.CassandraUnit;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.nineleaps.ecommerce.product.beans.Product;
//import com.nineleaps.ecommerce.product.constants.TestData;
//import com.nineleaps.ecommerce.product.controller.ProductController;
//import com.nineleaps.ecommerce.product.entity.ProductEntity;
//import com.nineleaps.ecommerce.product.repository.ProductRepository;
//import com.nineleaps.ecommerce.product.service.ProductService;
//
//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
//@SpringBootTest({ "spring.data.cassandra.port=9042", "spring.data.cassandra.keyspace-name=bezkoder" })
//@EnableAutoConfiguration
//@ComponentScan
//@ContextConfiguration
//@CassandraDataSet(value = { "create-table.cql" }, keyspace = "bezkoder")
//@CassandraUnit
//public class ProductControllerTest1 {
//	
//	@Autowired
//    ProductController productController;
//	
//	@Mock
//    ProductService productService;
//	
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private ProductRepository productRepository;	
//	
//	private ProductService mockProductService = null;
//	
//	@BeforeEach
//	public void init() {
//
//		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//		// mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//
//	}
//	
//	@Test
//	@DisplayName("testCreateProduct")
//    public void testCreateProduct() throws JsonMappingException, JsonProcessingException 
//    {
////        MockHttpServletRequest request = new MockHttpServletRequest();
////        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//         
//        ObjectMapper mapper = new ObjectMapper();
//        mockProductService = Mockito.mock(ProductService.class);
//        Product product = mapper.readValue(TestData.productReuestData, Product.class);
//        
//         
//        ProductEntity prod = productService.createProduct(product);
//         
//        assertThat(prod.getProductId()).isEqualTo("P003");
//    }
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
