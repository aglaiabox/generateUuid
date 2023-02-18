package com.example.generateUuid.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmailInfo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String mail;
    String uuid;
}
