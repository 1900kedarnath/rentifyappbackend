package com.rentify.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentify.app.entity.PropertyDetailsEntity;
import com.rentify.app.model.LikeCount;
import com.rentify.app.model.SellerDetails;
import com.rentify.app.repository.LoginCredentialRepository;
import com.rentify.app.services.EmailServices;
import com.rentify.app.services.LoginCredentialServices;
import com.rentify.app.services.PropertyDetailsService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rentify/buyer")
public class BuyerController {

	
	@Autowired
	private PropertyDetailsService propertyDetailsService;
		
	@Autowired
	private LoginCredentialServices loginCredentialServices;
	@Autowired
	private EmailServices emailServices;

//@GetMapping("/home")
//public ResponseEntity showAllPost(@RequestParam(defaultValue = "1") int page,
//        @RequestParam(defaultValue = "10") int size,
//        @RequestParam(defaultValue = "district") String sortBy){
//	
//	  Page<PropertyDetailsEntity> allPage=null;
//	List<PropertyDetailsEntity>  propertyDetailsEntity=null;
//	try {
//		 allPage=propertyDetailsService.getAllPost(page,size,sortBy);
//	}
//	catch(Exception e) {
//		
//		System.out.println(e) ;
//	}
//	
//	System.out.println(allPage.getNumber()+" "+allPage.getNumberOfElements() + "all page");
//	return  ResponseEntity.ok(allPage);
//	
//}
	
	@GetMapping("/home")
	public ResponseEntity showAllPost( ){
		
		  Page<PropertyDetailsEntity> allPage=null;
		List<PropertyDetailsEntity>  propertyDetailsEntity=null;
		try {
			propertyDetailsEntity=propertyDetailsService.getAllPost();
		}
		catch(Exception e) {
			
			System.out.println(e) ;
		}
		
		//System.out.println(allPage.getNumber()+" "+allPage.getNumberOfElements() + "all page");
		return  ResponseEntity.ok(propertyDetailsEntity);
		
	}
	
@PutMapping("/likeupdate")	
public ResponseEntity updateLikeCount(@RequestBody LikeCount likeCount){
	
	propertyDetailsService.updateLike(likeCount.getPostId(), likeCount.getCount());
	
	return ResponseEntity.ok("like updated");
	
}
	
@GetMapping("/seller/{data}/{id}")
public ResponseEntity<SellerDetails> sendDetails(@PathVariable int data,@PathVariable int id ){
	
	
	
	
	SellerDetails sellerDetails1=loginCredentialServices.findDetails(id);
	SellerDetails sellerDetails2=loginCredentialServices.findDetails(data);

	String buyerDetails="This "+" "+sellerDetails2.getFirstName()+" "+"buyer is interested in your room. You can communicate with him "
			+ "at this email "+sellerDetails2.getEmailAddress()+"\n"+"Thanks for using our services"+ "\n"+"Thanks & Regrads"+"\n"+" RentifyApp Team";
	
	String sellerDetails="Thank you for taking interest in the property of this "+" "+sellerDetails1.getFirstName()+" "+sellerDetails1.getLastName()
	+" " +"Here is the details of the seller"+ "  " +"Email Address"+ " "+sellerDetails1.getEmailAddress()+ " "+"Phone Number"+" "+sellerDetails1.getPhoneNumber()
	+ " " +"you can speak with seller at the corresponding contact details"+ "\n"+"Thanks & regards " + "\n"+"RentifyApp Team" ;
	
	emailServices.sendSimpleEmail(sellerDetails1.getEmailAddress(), "Details Of Buyer", buyerDetails);
	emailServices.sendSimpleEmail(sellerDetails2.getEmailAddress(), "Details Of Seller ", sellerDetails);

	return new ResponseEntity<>(sellerDetails1,HttpStatus.OK);
}
	
	
}
