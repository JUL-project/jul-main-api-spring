package com.jul.project.service.impl;

import com.jul.project.model.LinkedAccount;
import com.jul.project.model.User;
import com.jul.project.model.vo.CreateLinkedAccountVo;
import com.jul.project.repository.LinkedAccountRepository;
import com.jul.project.service.LinkedAccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LinkedAccountServiceImpl implements LinkedAccountService {

    private final LinkedAccountRepository accountRepository;

    @Override
    public LinkedAccount getLinkedAccount(User userNid) {
        List<LinkedAccount> lists = accountRepository.findByUserNid(userNid);
        if (!lists.isEmpty()) return lists.get(0);
        return null;
    }

    @Override
    public LinkedAccount createLinkedAccount(User userNid, CreateLinkedAccountVo linkedAccountVo) {
        LinkedAccount linkedAccount = new LinkedAccount();
        linkedAccount.setUserNid(userNid);
        linkedAccount.setPlatform(linkedAccountVo.getPlatform());
        linkedAccount.setAccessToken(linkedAccountVo.getAccessToken());
        linkedAccount.setRefreshToken(linkedAccountVo.getRefreshToken());
        accountRepository.save(linkedAccount);
        return linkedAccount;
    }

    @Override
    public LinkedAccount updateLinkedAccount(User userNid) {
        return null;
    }

    @Override
    public String deleteLinkedAccount(User userNid) {
        return "success";
    }
}
