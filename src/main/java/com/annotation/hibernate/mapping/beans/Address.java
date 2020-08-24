package com.annotation.hibernate.mapping.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")

public class Address implements Serializable {
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;

@Column(name="street")	
private String street;
@Column(name="doorNum")
private int doorNum;
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public int getDoorNum() {
	return doorNum;
}
public void setDoorNum(int doorNum) {
	this.doorNum = doorNum;
}


}
