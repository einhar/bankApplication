package com.ehr.controllers;

import com.ehr.model.Account;
import com.ehr.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

/*
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable("id")Integer accountNo) {
        System.out.println("Requested account number: " + accountNo);
        Account account = accountService.getAccount(accountNo);
        return account;
    }

    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<Account> postAccount(@RequestBody Account accnt) {
        System.out.println("Requested account number: " + accnt.getAccountNo());
        Account account = accountService.getAccount(accnt.getAccountNo());
        if (account == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
*/
/*
    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Account> getAccount(int accountNo) {
        Account account = accountService.getAccount(accountNo);
        if (account == null) {
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
*/

    @RequestMapping(/*value = "/{id}",*/ method=RequestMethod.POST)
    public ResponseEntity<Account> getAccount(@RequestBody Account accnt) {
        System.out.println("Requested account number: " + accnt.getAccountNo());
        Account account = accountService.getAccount(accnt.getAccountNo());
        if (account == null) {
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

}
