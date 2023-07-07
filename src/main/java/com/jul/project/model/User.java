package com.jul.project.model;

import com.jul.project.model.vo.CreateUserVo;
import jakarta.persistence.*;
import lombok.Builder;
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
    private String useYn;
    @Column(insertable = false, updatable = false)
    private LocalDateTime createDtm;
    @Column(insertable = false, updatable = false)
    private LocalDateTime updateDtm;

    @Builder
    public User(CreateUserVo vo) {
        this.userId = vo.getUserId();
        this.password = vo.getPassword();
    }

}
