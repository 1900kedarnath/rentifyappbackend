package com.rentify.app.controller ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentify.app.model.Buyer;
import com.rentify.app.model.LoginCredentials;
import com.rentify.app.model.SignInCredentials;
import com.rentify.app.model.SignInResponse;
import com.rentify.app.services.LoginCredentialServices;

@RestController
//@CrossOrigin("*")
@RequestMapping("rentify/login")
public class LoginController {


@Autowired
private LoginCredentialServices loginCredentialServices;
	
	
	

@PostMapping("/home")
public ResponseEntity buyerLogin(@RequestBody LoginCredentials loginCredentials) {
	
	try {
		System.out.println(loginCredentials.getFirstName()) ;
	loginCredentialServices.saveLoginCredential(loginCredentials);
	}
	catch(Exception e){
		System.out.println(e);
	}

    return new ResponseEntity<>(HttpStatus.CREATED);
}

@PostMapping("/signin")
public ResponseEntity<SignInResponse> userLogin(@RequestBody SignInCredentials signInCredentials) {
	SignInResponse  signInResponse=new SignInResponse();
	try {
		signInResponse=loginCredentialServices.verification(signInCredentials);
	}
	catch(Exception e){
		System.out.println(e);
	}

	if(signInResponse.getMsg().equals("Correct Password"))
	 return new ResponseEntity<>(signInResponse,HttpStatus.OK) ;
	
     return new ResponseEntity<>(signInResponse,HttpStatus.UNAUTHORIZED) ; 
     }



@PostMapping("/seller")
public ResponseEntity<Buyer> sellerLogin(@RequestBody LoginCredentials loginCredentials) {
	
	try {
		loginCredentialServices.saveLoginCredential(loginCredentials);
		}
		catch(Exception e){
			System.out.println(e);
		}
    return new ResponseEntity<>( HttpStatus.CREATED);
}


}
