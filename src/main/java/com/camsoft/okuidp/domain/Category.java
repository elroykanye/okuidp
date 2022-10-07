package com.camsoft.okuidp.domain;

import java.io.Serializable;
import java.util.ArrayList;
/* allows us to convert an Object to stream that we can send over the network or 
 * save it as file or store in DB for later usage*/
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name ="category")
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long Id;
	private String name; 
	
	@JsonBackReference
	@OneToMany(mappedBy ="category",cascade=CascadeType.ALL)
    private List<Problem> problems;
	
	@JsonBackReference
	@OneToMany(mappedBy ="category",cascade=CascadeType.ALL)
    private List<Interest> interests;
	
	
	public Category(String catName) {
		this.name = catName;
	}
	
	public Category() {
		
	}
	
	public List<Problem> getProblems() {
		return problems;
	}
	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}
	public List<Interest> getInterests() {
		return interests;
	}
	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Category [Id=" + Id + ", name=" + name + "]";
	}
	
}
