package com.camsoft.okuidp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "IDPAnswers")
public class IDPAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private IDP idp;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Answer answer;


	private LocalDate answereddate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public IDP getIdp() {
		return idp;
	}

	public void setIdp(IDP idp) {
		this.idp = idp;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public LocalDate getAnswereddate() {
		return answereddate;
	}

	public void setAnswereddate(LocalDate answereddate) {
		this.answereddate = answereddate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(answer, idp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IDPAnswer other = (IDPAnswer) obj;
		return Objects.equals(answer, other.answer) && Objects.equals(idp, other.idp);
	}

	@Override
	public String toString() {
		return "IDPAnswer [id=" + id + ", idp=" + idp.toString() + ", answer=" + answer.toString() + ", answereddate=" + answereddate + "]";
	}



	
	
	
	
	
}
