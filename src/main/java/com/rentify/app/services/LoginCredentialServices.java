package com.rentify.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rentify.app.entity.LoginCredentialEntity;
import com.rentify.app.model.LoginCredentials;
import com.rentify.app.model.SellerDetails;
import com.rentify.app.model.SignInCredentials;
import com.rentify.app.model.SignInResponse;
import com.rentify.app.repository.LoginCredentialRepository;

@Service
public class LoginCredentialServices {

@Autowired
private LoginCredentialRepository loginCredentialRepository;
			
	
	
public void saveLoginCredential(LoginCredentials userLogin ){
	

	
	
	LoginCredentialEntity LoginCredentialEntity=new LoginCredentialEntity();
	
	LoginCredentialEntity.setFirstName(userLogin.getFirstName());
	LoginCredentialEntity.setLastName(userLogin.getLastName());
	LoginCredentialEntity.setEmailAddress(userLogin.getEmailAddress());
	LoginCredentialEntity.setPhoneNumber(userLogin.getPhoneNumber());
	LoginCredentialEntity.setPassword(userLogin.getPassword());

	LoginCredentialEntity.setUserType(userLogin.getUserType());
	
	
	loginCredentialRepository.save(LoginCredentialEntity);
	
	
}

public SellerDetails findDetails(int id) {
	Optional<LoginCredentialEntity> loginCredentialEntity1= loginCredentialRepository.findByUserId(id);
	SellerDetails sellerDetails=new SellerDetails();
	try {
	if(loginCredentialEntity1.isPresent())
	{
		
		LoginCredentialEntity loginCredentialEntity=loginCredentialEntity1.get() ;
		sellerDetails.setFirstName(loginCredentialEntity.getFirstName());
		sellerDetails.setLastName(loginCredentialEntity.getLastName());
		sellerDetails.setPhoneNumber(loginCredentialEntity.getPhoneNumber());
		sellerDetails.setEmailAddress(loginCredentialEntity.getEmailAddress());
		
	}
	}
	catch(Exception e)
	{
		
	}
	
	return sellerDetails ;
}

public SignInResponse verification(SignInCredentials signInCredentials) {
	System.out.println(signInCredentials.getEmail()+"kedar email"+"passwor"+signInCredentials.getPassword());
	Optional<LoginCredentialEntity> loginCredentialEntity1 =loginCredentialRepository.findByEmailAddress(signInCredentials.getEmail());
	SignInResponse signInResponse=new SignInResponse(); 
	if(loginCredentialEntity1.isPresent())
	{
		LoginCredentialEntity loginCredentialEntity=loginCredentialEntity1.get() ;
	if(signInCredentials.getPassword().equals(loginCredentialEntity.getPassword())) {
	
		signInResponse.setUserId(loginCredentialEntity.getUserId());
		signInResponse.setUserType(loginCredentialEntity.getUserType());
		signInResponse.setMsg("Correct Password");
		return signInResponse ; 
	
	}
	}
	signInResponse.setMsg("Wrong Password");
	
	return signInResponse;
	
	
}


}
