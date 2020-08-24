package com.annotation.hibernate.mapping.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="student")
@Proxy(lazy = false)
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)// This case hibernate will look for table hibernate_sequence
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String name;
	@OneToOne(cascade=CascadeType.ALL)//Should not use @Column when @OneToOne used,because column names will be different
	//Fetch type is used to fetch strategy 
	private Address address;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)//Should not use @Column when @ManyToOne used
	private List<Marks> marks;//when one to many present make sure u r defining list or collcetion

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Marks> getMarks() {
		return marks;
	}

	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	
	
}
