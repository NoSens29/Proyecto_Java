package com.informatorio.proyectoinformatorio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false,length = 30)
    @NotBlank
    @Size(min = 4)
    private String name;


    @OneToMany
    private List<Post> posts = new ArrayList<>();


    private String email;

    private String lastname;

    @JsonIgnore
    private String password;

    private LocalDate date =  LocalDate.now();

    private String city;

    private String province;

    private String country;

    //getter and setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getName(){
        return  name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastname(){
        return  lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return  password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public LocalDate getCreationdate(){
        return date;
    }

    public void setCreationdate(LocalDate date){
        this.date = date;
    }

    public String getCity(){
        return  city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getProvince(){
        return province;
    }

    public void setProvince(String province){
        this.province = province;
    }

    public String getCountry(){
        return  country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void addPost(Post post){
        this.posts.add(post);
        post.setAuthor(this);
    }
}
