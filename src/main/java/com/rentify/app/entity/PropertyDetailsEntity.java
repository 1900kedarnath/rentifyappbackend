package com.rentify.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="PropertyDetails")
public class PropertyDetailsEntity {


	
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer postId;

@ManyToOne
@JoinColumn(name="userId", nullable=false)
private LoginCredentialEntity userId;
private String place;
private String street;
private String district;
private String state;
private String country;
private String numberOfBedroom;
private String bathroom;
private String uploadRoomImage;
private int likeCount;




public int getLikeCount() {
	return likeCount;
}
public void setLike(int like) {
	this.likeCount = like;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getNumberOfBedroom() {
	return numberOfBedroom;
}
public void setNumberOfBedroom(String numberOfBedroom) {
	this.numberOfBedroom = numberOfBedroom;
}
public String getBathroom() {
	return bathroom;
}
public void setBathroom(String bathroom) {
	this.bathroom = bathroom;
}
public String getUploadRoomImage() {
	return uploadRoomImage;
}
public void setUploadRoomImage(String uploadRoomImage) {
	this.uploadRoomImage = uploadRoomImage;
}
public Integer getPostId() {
	return postId;
}
public void setPostId(Integer postId) {
	this.postId = postId;
}
public LoginCredentialEntity getUserId() {
	return userId;
}
public void setUserId(LoginCredentialEntity userId) {
	this.userId = userId;
}


	
	
}
