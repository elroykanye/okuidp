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

import com.camsoft.okuidp.util.AnswerType;

@Entity
@Table(name = "answers")
public class Answer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String Answer;
	private AnswerType type;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Question question;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "answer")
	private List<IDPAnswer> idpanswers;
	
	public Answer(Question question) {
		this.question = question;
	}
	
	public Answer() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public AnswerType getType() {
		return type;
	}

	public void setType(AnswerType type) {
		this.type = type;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<IDPAnswer> getIdpanswers() {
		return idpanswers;
	}

	public void setIdpanswers(List<IDPAnswer> idpanswers) {
		this.idpanswers = idpanswers;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", Answer=" + Answer + ", type=" + type + ", question=" + question + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Answer, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		return Objects.equals(Answer, other.Answer) && id == other.id;
	}

	
}
