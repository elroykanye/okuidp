package com.camsoft.okuidp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Objects;

//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.camsoft.okuidp.util.Gender;
import com.camsoft.okuidp.util.IDPType;
@Entity
@Table(name="idps")
public class IDP implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String Address;
	private String pastActivities;
	private int age;
	private LocalDate dob;
	
	private Gender gender;
	
	@Enumerated(EnumType.STRING)
	private IDPType type;
	
	private int numofminors;
	
	
	private String cni;

	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(
	            name = "idp_interest",
	            joinColumns = {@JoinColumn(name = "idp_id")},
	            inverseJoinColumns = {@JoinColumn(name = "interest_id")}
	 )
	 private List<Interest> Interests;
	 
		
	 @OneToMany(mappedBy = "idp")
	 private List<IDPAnswer> IDPAnswers;

	 

 	@OneToOne(targetEntity = Contact.class)
 	private Contact contact;
	
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    
    public IDP(User user, Contact contact) {
    	this.user = user;
    	this.contact = contact;
    }

	public IDP() {
		
	}

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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPastActivities() {
		return pastActivities;
	}

	public void setPastActivities(String pastActivities) {
		this.pastActivities = pastActivities;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public IDPType getType() {
		return type;
	}

	public void setType(IDPType type) {
		this.type = type;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cin) {
		this.cni = cin;
	}

	public int getNumofminors() {
		return numofminors;
	}

	public void setNumofminors(int numofminors) {
		this.numofminors = numofminors;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<Interest> getInterests() {
		return Interests;
	}

	public void setInterests(List<Interest> interests) {
		Interests = interests;
	}

	public List<IDPAnswer> getIDPAnswers() {
		return IDPAnswers;
	}

	public void setIDPAnswers(List<IDPAnswer> iDPAnswers) {
		IDPAnswers = iDPAnswers;
	}

	@Override
	public String toString() {
		return "IDP [id=" + id + ", name=" + name + ", Address=" + Address + ", pastActivities=" + pastActivities
				+ ", age=" + age + ", dob=" + dob + ", gender=" + gender + ", type=" + type + ", numofminors="
				+ numofminors + ", cni=" + cni + ", contact=" + contact + "]";
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(age, cni, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IDP other = (IDP) obj;
		return age == other.age && Objects.equals(cni, other.cni) && Objects.equals(name, other.name);
	}

}
