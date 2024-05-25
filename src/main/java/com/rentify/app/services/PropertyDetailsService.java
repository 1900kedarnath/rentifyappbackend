package com.rentify.app.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentify.app.entity.LoginCredentialEntity;
import com.rentify.app.entity.PropertyDetailsEntity;
import com.rentify.app.model.PropertyDetails;
import com.rentify.app.repository.AllPostRepository;
import com.rentify.app.repository.FindPropertyRepository;
import com.rentify.app.repository.LoginCredentialRepository;
import com.rentify.app.repository.PropertyDetailsRepository;

@Service
public class PropertyDetailsService {

	
@Autowired
private PropertyDetailsRepository  propertyDetailsRepository;

@Autowired 
private FindPropertyRepository findPropertyRepository ;
@Autowired
private LoginCredentialRepository loginCredentialRepository;

@Autowired
private AllPostRepository allPostRepository;

public void savePost(int id,PropertyDetails propertyDetails ) {
	
	Optional<LoginCredentialEntity> loginCredentialEntity=loginCredentialRepository.findById(id);
	
	LoginCredentialEntity loginCredentialEntity1=null;
	if(loginCredentialEntity.isPresent())
		loginCredentialEntity1=loginCredentialEntity.get() ;
	
	PropertyDetailsEntity propertyDetailsEntity=new PropertyDetailsEntity();
	
	propertyDetailsEntity.setBathroom(propertyDetails.getBathroom());
	propertyDetailsEntity.setCountry(propertyDetails.getCountry());
	propertyDetailsEntity.setDistrict(propertyDetails.getDistrict());
	propertyDetailsEntity.setNumberOfBedroom(propertyDetails.getNumberOfBedroom());
	propertyDetailsEntity.setPlace(propertyDetails.getPlace());
	propertyDetailsEntity.setState(propertyDetails.getState());
	propertyDetailsEntity.setStreet(propertyDetails.getStreet());
	propertyDetailsEntity.setUserId(loginCredentialEntity1);
	
	propertyDetailsRepository.save(propertyDetailsEntity);
}

public List<PropertyDetailsEntity> getPost(int id) {
	
	
Optional<LoginCredentialEntity> loginCredentialEntity=loginCredentialRepository.findById(id);
	
	LoginCredentialEntity loginCredentialEntity1=null;
	if(loginCredentialEntity.isPresent())
		loginCredentialEntity1=loginCredentialEntity.get() ;
 
   List<PropertyDetailsEntity> listOfPost=propertyDetailsRepository.findByUserId(loginCredentialEntity1);
   return listOfPost;
	
}

public void updateLike(int postId,int count) {
	
	System.out.println("postId"+postId);
	System.out.println("count"+count);
	propertyDetailsRepository.updateLikeCount(postId, count+1);
	
}

public void updatePost(int id, PropertyDetails propertyDetails ) {
	
	
Optional<PropertyDetailsEntity> propertyDetailsEntity1=propertyDetailsRepository.findById(id);
	
if(propertyDetailsEntity1.isPresent()) {

	PropertyDetailsEntity propertyDetailsEntity=propertyDetailsEntity1.get() ;
	
	propertyDetailsEntity.setBathroom(propertyDetails.getBathroom()!=null?propertyDetails.getBathroom():propertyDetailsEntity.getBathroom());
	propertyDetailsEntity.setCountry(propertyDetails.getCountry()!=null?propertyDetails.getCountry():propertyDetailsEntity.getCountry());
	propertyDetailsEntity.setDistrict(propertyDetails.getDistrict()!=null?propertyDetails.getDistrict():propertyDetailsEntity.getDistrict());
	propertyDetailsEntity.setNumberOfBedroom(propertyDetails.getNumberOfBedroom()!=null?propertyDetails.getNumberOfBedroom():propertyDetailsEntity.getNumberOfBedroom());
	propertyDetailsEntity.setPlace(propertyDetails.getPlace()!=null?propertyDetails.getPlace():propertyDetailsEntity.getPlace());
	propertyDetailsEntity.setState(propertyDetails.getState()!=null?propertyDetails.getState():propertyDetailsEntity.getState());
	propertyDetailsEntity.setStreet(propertyDetails.getStreet()!=null?propertyDetails.getStreet():propertyDetailsEntity.getStreet());
	
	propertyDetailsRepository.save(propertyDetailsEntity);
	
}
	
}

public List<PropertyDetailsEntity> getAllPost( ) {
	
   // Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
	//Page<PropertyDetailsEntity> allPage=allPostRepository.findAll(pageable);
	
	return allPostRepository.findAll() ;
	
	
	
}

@Transactional
public void deletePost(int id) {
	
	
	propertyDetailsRepository.deleteById(id);
	
}
	
}
