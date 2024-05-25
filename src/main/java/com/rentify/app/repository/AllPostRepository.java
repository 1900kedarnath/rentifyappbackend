package com.rentify.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rentify.app.entity.PropertyDetailsEntity;

//public interface AllPostRepository extends PagingAndSortingRepository<PropertyDetailsEntity,Integer> {
//	
//}

public interface AllPostRepository extends JpaRepository<PropertyDetailsEntity,Integer> {
	
	
}
