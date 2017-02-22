package com.wickedwitch.pojo;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
public class Person implements Serializable {

    public static final long serialVersionUID = 12345L;

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Date added;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");


    public Person(long id, String firstname, String lastname, String email, String username, String password, Date added) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.added = added;
    }

    public Person(){}


   @Override
   public String toString() {
       return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
               + ", username=" + username + ", password=" + password + ", added=" + added + "]";
   }
}
