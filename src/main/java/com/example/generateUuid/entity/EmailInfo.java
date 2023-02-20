package com.example.generateUuid.entity;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailInfo implements Serializable {

    String mail;
    String uuid;
}
