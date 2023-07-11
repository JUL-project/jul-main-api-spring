package com.jul.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
public class LinkedAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LinkedAccountNid;
    private String google;
    private String kakao;
    private String naver;
    @Column(insertable = false, updatable = false)
    private LocalDateTime createDtm;
    @Column(insertable = false, updatable = false)
    private LocalDateTime updateDtm;

}
