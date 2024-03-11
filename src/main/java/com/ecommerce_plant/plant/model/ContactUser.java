package com.ecommerce_plant.plant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactUser {
    private int user_id;
    private int address_category_id;
    private String address;
    private String phone_number;
}