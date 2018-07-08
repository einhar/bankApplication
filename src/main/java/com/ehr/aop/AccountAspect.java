package com.ehr.aop;

import com.ehr.dao.AccountDAO;
import com.ehr.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

    @Before("execution(* com.ehr.dao.AccountDAOImpl.saveAccount(..))")
    public void validateAccount(JoinPoint joinPoint) {
        System.out.println("Method: ValidateAccount id being processed.");
        Object []args = joinPoint.getArgs();
        Account account = (Account)args[0];
        AccountDAO accountDAO = (AccountDAO)joinPoint.getTarget();
        int accountNo = account.getAccountNo();
        System.out.println("accountNo: " + accountNo);
        if (accountDAO.getAccount(accountNo) != null /*&& accountNo == accountDAO.getAccount(accountNo).getAccountNo()*/) {
            System.out.println("Account: " + accountDAO.getAccount(accountNo).toString());
            System.out.println("Account with AccountNo: " + accountNo + " is already exists.");
            throw new RuntimeException("Account with AccountNo: " + accountNo + " is already exists.");
        }
    }
}
