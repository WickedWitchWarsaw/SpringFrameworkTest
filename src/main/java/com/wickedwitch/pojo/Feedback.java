package com.wickedwitch.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by ZuZ on 2016-12-30.
 */

@Data
public class Feedback implements Serializable {

    public static final long serialVersionUID = 987654321L;

    private String firstName;
    private String email;
    private String feedback;

}
