package com.camsoft.okuidp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String username;
    private String password;
    private boolean login;
    private String email;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<IDP> idps;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
        name = "user_role",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles;

    // create a constructor to hold user information
    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public void removeIDP(IDP idp) {
        idps.remove(idp);
        idp.setUser(null);
    }

    public void addRole(Role role) {
        if (!Objects.isNull(roles)) {
            roles.add(role);
        } else {
            roles = new ArrayList<>();
            roles.add(role);
        }
    }


    public void addIDP(IDP idp) {

        if (idps.isEmpty() || !Objects.isNull(idps)) {
            idps = new ArrayList<>();
            idps.add(idp);
            idp.setUser(this);
        } else {
            idps.add(idp);
            idp.setUser(this);
        }

    }

    public List<Role> getRole() {
        return roles;
    }

    public void setRole(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(name, other.name) && Objects.equals(username, other.username);
    }

    public Long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public List<IDP> getIdps() {
        return idps;
    }

    public void setIdps(List<IDP> idps) {
        this.idps = idps;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [Id=" + id + ", Name=" + name + ", Username=" + username + ", password="
            + password + ", Email=" + "]";
    }


}
