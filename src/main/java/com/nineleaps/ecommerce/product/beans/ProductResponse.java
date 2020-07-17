package com.nineleaps.ecommerce.product.beans;

import org.springframework.stereotype.Component;

@Component
public class ProductResponse {
	public String message;
	public String code;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
