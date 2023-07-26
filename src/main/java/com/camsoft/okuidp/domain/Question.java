package com.camsoft.okuidp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "questions")

public class Question implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Problem problem;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "question")
    private Answer answer;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Questionaire questionaire;

    public Question(Questionaire questionaire, Problem problem, String name) {
        this.questionaire = questionaire;
        this.problem = problem;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Answer getAnswer() {
        return answer;
    }


    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Questionaire getQuestionaire() {
        return questionaire;
    }

    public void setQuestionaire(Questionaire questionaire) {
        this.questionaire = questionaire;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "Question [Id=" + Id + ", name=" + name + ", problem=" + problem + ", answer=" + answer
            + ", questionaire=" + questionaire + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, problem, questionaire);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Question other = (Question) obj;
        return Objects.equals(name, other.name) && Objects.equals(problem, other.problem)
            && Objects.equals(questionaire, other.questionaire);
    }


}
