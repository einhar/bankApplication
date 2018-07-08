package com.ehr.dao;

import com.ehr.entity.AccountEntity;
import com.ehr.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean saveAccount(Account account) {
        boolean saveFlag = true;
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccNo(account.getAccountNo());
        accountEntity.setAccHolderName(account.getAccountHolderName());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setAccountType(account.getAccountType());
        accountEntity.setDateOfBirth(account.getDateOfBirth());
        accountEntity.setPsCode(account.getPsCode());
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.save(accountEntity);
            //currentSession.saveOrUpdate(accountEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
            saveFlag = false;
            System.out.println("AccountDAOImpl.saveAccount() thrown the exception. Flag has been setted to false.");
        }
        return saveFlag;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> list = new ArrayList<>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Query<AccountEntity> query = session.createQuery("From AccountEntity", AccountEntity.class);
            List<AccountEntity> accounts = query.getResultList();
            for (int i = 0; i < accounts.size(); i++) {
                AccountEntity accountEntity = (AccountEntity) accounts.get(i);
                Account account = new Account();
                account.setAccountNo(accountEntity.getAccNo());
                account.setAccountHolderName(accountEntity.getAccHolderName());
                account.setBalance(accountEntity.getBalance());
                account.setAccountType(accountEntity.getAccountType());
                account.setDateOfBirth(accountEntity.getDateOfBirth());
                account.setPsCode(accountEntity.getPsCode());
                list.add(account);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Account getAccount(Integer accountNo) {
        Account account = new Account();
        try {
            Session session = sessionFactory.getCurrentSession();
            /*session.GET() returns null if empty, but session.LOAD() doesn't*/
            AccountEntity accountEntity = (AccountEntity) session.get(AccountEntity.class, accountNo);
            if (accountEntity != null) {
                account.setAccountNo(accountEntity.getAccNo());
                account.setAccountHolderName(accountEntity.getAccHolderName());
                account.setBalance(accountEntity.getBalance());
                account.setAccountType(accountEntity.getAccountType());
                account.setDateOfBirth(accountEntity.getDateOfBirth());
                account.setPsCode(accountEntity.getPsCode());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (!accountNo.equals(account.getAccountNo())) account = null;

        return account;
    }

    @Override
    public boolean deleteAccount(int accountNo) {
        boolean deleteFlag=true;
        try {
            Session session = sessionFactory.getCurrentSession();
            AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class, accountNo);
            session.delete(accountEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
            deleteFlag = false;
        }
        return deleteFlag;
    }
}
