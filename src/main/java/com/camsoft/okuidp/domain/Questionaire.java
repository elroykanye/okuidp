package com.camsoft.okuidp.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questionaires")
public class Questionaire implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "questionaire", cascade = CascadeType.ALL)
	private List<Question> questions;

	public Questionaire() {
		
	}
	
	public Questionaire(String questName) {
		this.name = questName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuestion() {
		return name;
	}
	public void setQuestion(String name) {
		this.name = name;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Questionaire [id=" + id + ", name=" + name  + ", getName()=" + getName()
				+ ", getId()=" + getId() + ", getQuestion()=" + getQuestion() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questionaire other = (Questionaire) obj;
		return Objects.equals(name.toLowerCase(), other.name.toLowerCase());
	}
}
