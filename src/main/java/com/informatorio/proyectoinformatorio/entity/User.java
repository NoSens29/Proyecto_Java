package com.informatorio.proyectoinformatorio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false,length = 30)
    private String name;

    //@Column(unique = true)
    //@OneToMany(mappedBy = "author", fetch = FetchType.LAZY,
    //    cascade = CascadeType.ALL)
    //private Set<Post> posts;

    private String email;

    private String lastname;

    @JsonIgnore
    private String password;

    @CreationTimestamp
    private LocalDate creationdate;

    private String city;

    private String province;

    private String country;


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
        return creationdate;
    }

    public void setCreationdate(LocalDate creationdate){
        this.creationdate = creationdate;
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
}
