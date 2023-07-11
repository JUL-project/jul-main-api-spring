package com.jul.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNid;
    private String userId;
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linked_account_nid")
    private LinkedAccount linkedAccount;
    @Column(insertable = false)
    private String useYn;
    @Column(insertable = false, updatable = false)
    private LocalDateTime createDtm;
    @Column(insertable = false, updatable = false)
    private LocalDateTime updateDtm;

}
