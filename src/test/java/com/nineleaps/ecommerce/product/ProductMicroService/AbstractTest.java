//package com.nineleaps.ecommerce.product.ProductMicroService;
//
//import java.io.IOException;
//
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.nineleaps.ecommerce.product.ProductMicroServiceApplication;
//import com.nineleaps.ecommerce.product.controller.ProductController;
//
//@RunWith(JUnitPlatform.class)
//@SpringBootTest({ "sspring.data.cassandra.port=90422", "spring.data.cassandra.keyspace-name=bezkoder" })
//@EnableAutoConfiguration
//@ComponentScan
//@ContextConfiguration
////@CassandraDataSet(value = { "cassandra-init.sh" }, keyspace = "cycling1")
////@CassandraUnit
//public abstract class AbstractTest {
//
//	protected MockMvc mockMvc;
//
//	@Autowired
//	public ProductController productController;
//
//	/*
//	 * public void setUp() { // mockMvc =
//	 * MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); mockMvc =
//	 * MockMvcBuilders.standaloneSetup(productController).build(); }
//	 */
//
//	protected String mapToJson(Object obj) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.writeValueAsString(obj);
//	}
//
//	protected <T> T mapFromJson(String json, Class<T> clazz)
//			throws JsonParseException, JsonMappingException, IOException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.readValue(json, clazz);
//	}
//}
