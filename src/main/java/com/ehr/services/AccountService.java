package com.ehr.services;

import com.ehr.model.Account;

import java.util.List;

public interface AccountService {

    public Boolean saveAccount(Account account);

    public List<Account> getAccounts();

    public Account getAccount(Integer accountNo);

    public boolean deleteAccount(int accountNo);
}
