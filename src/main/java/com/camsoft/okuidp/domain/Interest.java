package com.camsoft.okuidp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Interests")
public class Interest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<IDP> idps;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Interest(String interestName) {
        this.name = interestName;
    }

    public Interest() {

    }

    public List<IDP> getIdps() {
        return idps;
    }

    public void setIdps(List<IDP> idps) {
        this.idps = idps;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
