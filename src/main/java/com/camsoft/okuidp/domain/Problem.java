package com.camsoft.okuidp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "problems")
public class Problem implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Category category;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "problem")
    private List<Question> questions;

    public Problem(Category category2, String problemName) {
        this.category = category2;
        this.name = problemName;
    }


    public Problem() {
    }

    public Problem(Category cat) {
        this.category = cat;
    }

    public void addQuestion(Question question) {
        if (Objects.isNull(questions) || questions.isEmpty()) {
            questions = new ArrayList<Question>();
            questions.add(question);
            question.setProblem(this);
        } else {
            questions.add(question);
            question.setProblem(this);
        }
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
        question.setProblem(null);
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Problem [Id=" + Id + ", name=" + name + ", category=" + category.toString() + "]";
    }


}

