package com.nineleaps.ecommerce.product.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nineleaps.ecommerce.product.beans.Supplier;

@FeignClient(name="SupplierMicroService",url = "http://localhost:8084")
@RibbonClient(name="SupplierMicroService")
public interface FeignController {

	@GetMapping(value= "supplier/getSupplier/{id}")
	public Supplier checkSupplierAvailability(@PathVariable String id);
}
