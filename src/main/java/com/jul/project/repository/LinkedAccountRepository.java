package com.jul.project.repository;

import com.jul.project.model.LinkedAccount;
import com.jul.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkedAccountRepository extends JpaRepository<LinkedAccount, Long> {
    List<LinkedAccount> findByUserNid(User userNid);
}
