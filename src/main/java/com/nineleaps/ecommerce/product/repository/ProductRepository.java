package com.nineleaps.ecommerce.product.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nineleaps.ecommerce.product.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, String>{

}
