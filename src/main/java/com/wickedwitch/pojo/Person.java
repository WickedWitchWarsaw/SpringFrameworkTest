package com.wickedwitch.pojo;

import lombok.Data;

import java.io.Serializable;


@Data
public class Person implements Serializable {

    public static final long serialVersionUID = 12345L;

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;

}
