package com.ehr.controllers;

import com.ehr.model.Account;
import com.ehr.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

    @RequestMapping("/check")
    public String checkFunction() {
        return "check";
    }

	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("showHomePage();");
		return "index";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
    public String viewAccount(Model model) {
	    return "findAccount";
    }
	
	@RequestMapping("/new")
	public String newAccount(Model model) {
		model.addAttribute("account", new Account());
		return "account-form";
	}
	
	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";
	}
	
	@RequestMapping(value="/saveAccount",method=RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute("account") Account account,
                              BindingResult result, Model model
    ) {
		/*model.addAttribute("account", account);
		return "showAccount";*/

		/*if (result.hasErrors()) {
            return "account-form";
        } else {
            System.out.println("accountService.saveAccount(account);");
            accountService.saveAccount(account);
			return "redirect:/list";
        }*/

		if (result.hasErrors())
			return "account-form";
		else {
			String message = "";
			boolean flag =true;
			try {
				flag= accountService.saveAccount(account);
			}
			catch(Exception ex) {
				message = ex.getMessage();
				flag=false;
			}
			if(!flag) {
				model.addAttribute("message", message);
				return "account-form";
			}
			model.addAttribute("account", account);
			return "redirect:/list";
		}
	}

	@RequestMapping("/list")
	public String listAccounts(Model model) {
        List<Account> accounts = accountService.getAccounts();
        model.addAttribute("accounts", accounts);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		model.addAttribute("username", name);

        return "listAccounts";
    }

    @RequestMapping("/edit")
    public String updateAccount(@RequestParam("accountNo") int accountNo, Model model) {
	    Account account = accountService.getAccount(new Integer(accountNo));
	    model.addAttribute("account", account);
	    return "account-form";
    }

    @RequestMapping("/delete")
    public String deleteAccount(@RequestParam("accountNo") int accountNo, Model model) {
	    accountService.deleteAccount(accountNo);
        return "redirect:/list";
    }

}
