package com.ehr.services;

import com.ehr.dao.AccountDAO;
import com.ehr.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    @Transactional
    public Boolean saveAccount(Account account) {
        return accountDAO.saveAccount(account);
    }

    @Override
    @Transactional
    public List<Account> getAccounts() {
        return accountDAO.getAccounts();
    }

    @Override
    @Transactional
    public Account getAccount(Integer accountNo) {
        return accountDAO.getAccount(accountNo);
    }

    @Override
    @Transactional
    public boolean deleteAccount(int accountNo) {
        return accountDAO.deleteAccount(accountNo);
    }
}
