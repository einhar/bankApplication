package com.ehr.dao;

import com.ehr.model.Account;

import java.util.List;

public interface AccountDAO {

    public boolean saveAccount(Account account);

    public List<Account> getAccounts();

    public Account getAccount(Integer accountNo);

    public boolean deleteAccount(int accountNo);
}
