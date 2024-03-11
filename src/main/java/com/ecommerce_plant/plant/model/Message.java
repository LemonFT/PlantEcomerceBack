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
public class Message {
    private int id;
    private int user_send_id;
    private int user_receive_id;
    private String content;
    private Date time;
    private int reply_mess_id;
}
