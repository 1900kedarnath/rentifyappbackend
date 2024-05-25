package com.rentify.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentify.app.entity.PropertyDetailsEntity;

public interface FindPropertyRepository  extends JpaRepository<PropertyDetailsEntity,Integer>{
	

}
