package com.nineleaps.ecommerce.product.entity;

import java.io.Serializable;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("PRODUCT")
public class ProductEntity implements Serializable	{

	@PrimaryKey 
	private String productId;
	@Column("name")
	private String name;
	@Column("price")
	private String price;
	@Column("description")
	private String description;
	@Column("supplierid")
	private String supplierId;
	
	public ProductEntity() {
	}
	
	public ProductEntity(String productId, String name, String price, String description, String supplierId) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.supplierId = supplierId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", name=" + name + ", price=" + price + ", description="
				+ description + ", supplierId=" + supplierId + "]";
	}
	
}
