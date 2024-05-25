package com.rentify.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rentify.app.entity.LoginCredentialEntity;
import com.rentify.app.entity.PropertyDetailsEntity;

@Repository
public interface PropertyDetailsRepository extends CrudRepository<PropertyDetailsEntity,Integer>{

	List<PropertyDetailsEntity> findByUserId(LoginCredentialEntity loginCredentialEntity);
	
	@Modifying
    @Transactional
    @Query("UPDATE PropertyDetailsEntity u SET u.likeCount = :count WHERE u.id = :id")
    int updateLikeCount(@Param("id") int id, @Param("count") int count);
}
