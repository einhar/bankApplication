package com.ehr.model;

import com.ehr.validations.PSCode;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.*;

import java.util.Date;

public class Account {

    @NotNull/*(message = "Account# cannot be blank")*/
	private Integer accountNo;

    @NotNull(message = "Account Holder name cannot be blank")
    @Size(min = 2, max = 50, message = "Invalid length for Account Holder Name")
    /*@Pattern(regexp = "[A-Za-z(\\s)+]", message = "Invalid Account Holder Name")*/
    private String accountHolderName;

    @NotNull(message = "Balance amount is required")
    @Min(value = 5000, message = "Minimum balance cannot be less than 5000")
	private Integer balance;

    @NotNull(message = "Account Type cannot be null")
	private String accountType;

    @NotNull(message = "Date Of Birth cannot be null")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Past(message = "Account cannot be created for a person not born")
    private Date dateOfBirth;

    @NotNull(message = "PS Code is required")
    @PSCode
	private String psCode;

    public Account() {
        accountNo = 0;
        accountHolderName = "";
        balance = 0;
        accountType = "";
        dateOfBirth = new Date();
        psCode  = "";
    }

    public Account(Integer accNo, String holderName, Integer balance,
                   String accType, Date dob, String psCode
    ) {
        this.accountNo = accNo;
        this.accountHolderName = holderName;
        this.balance = balance;
        this.accountType = accType;
        this.dateOfBirth = dob;
        this.psCode = psCode;
    }

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPsCode() {
        return psCode;
    }

    public void setPsCode(String psCode) {
        this.psCode = psCode;
    }


    @Override
	public String toString() {
		return "Account{" +
				"accountNo=" + accountNo +
				", accountHolderName='" + accountHolderName + '\'' +
				", balance=" + balance +
				'}';
	}
}
