package com.rentify.app.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentify.app.entity.PropertyDetailsEntity;
import com.rentify.app.model.PropertyDetails;
import com.rentify.app.services.PropertyDetailsService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rentify/seller/")
public class SellerController {

@Autowired
private PropertyDetailsService propertyDetailsService;
	
	

@PostMapping("addpost/{id}")
public ResponseEntity addPost(@PathVariable int id  ,@RequestBody PropertyDetails  propertyDetails ){
	
	try {
		
		propertyDetailsService.savePost(id,propertyDetails);	
	}
	catch(Exception e) {
		System.out.print(e);
	}
	
	
	
	return new ResponseEntity(HttpStatus.CREATED);
	
}

@GetMapping("seepost/{id}")

public ResponseEntity<List<PropertyDetailsEntity>> seePost(@PathVariable int id) {
	
	List<PropertyDetailsEntity> listOfPost=propertyDetailsService.getPost(id);
	
	return new ResponseEntity<>(listOfPost,HttpStatus.OK);
	
}

@PutMapping("updatepost/{id}")
public ResponseEntity updatePost(@PathVariable int id, @RequestBody PropertyDetails propertyDetails) {
     propertyDetailsService.updatePost(id, propertyDetails);
     return new ResponseEntity<>(HttpStatus.OK);
}
	


@DeleteMapping("deletepost/{id}")
public ResponseEntity<Void> deletePost(@PathVariable int id) {
	propertyDetailsService.deletePost(id);
    return ResponseEntity.noContent().build();
}

}
