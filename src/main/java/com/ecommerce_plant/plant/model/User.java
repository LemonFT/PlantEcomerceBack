package com.ecommerce_plant.plant.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private boolean gender;
    private Date join_date;
    private int role_id;
    private boolean block;

}