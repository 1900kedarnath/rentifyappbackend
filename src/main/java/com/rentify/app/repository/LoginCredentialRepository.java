package com.rentify.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentify.app.entity.LoginCredentialEntity;

@Repository
public interface LoginCredentialRepository extends JpaRepository<LoginCredentialEntity,Integer> {

	
	Optional<LoginCredentialEntity> findByEmailAddress(String emailAddress);
	Optional<LoginCredentialEntity> findByUserId(int id);
}
