package com.annotation.hibernate.mapping.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marks")
public class Marks {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name="math")
private int mathMarks;
@Column(name="science")
private int scienceMarks;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getMathMarks() {
	return mathMarks;
}
public void setMathMarks(int mathMarks) {
	this.mathMarks = mathMarks;
}
public int getScienceMarks() {
	return scienceMarks;
}
public void setScienceMarks(int scienceMarks) {
	this.scienceMarks = scienceMarks;
}

}
