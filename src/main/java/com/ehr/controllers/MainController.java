package com.ehr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String welcome(Model model) {
        model.addAttribute("greetings", "Lorem ipsum... (greetings attribute)");
        model.addAttribute("tagline", "Lorem lorem... (tagline attribute)");
        return "forward:/welcome/greeting";
    }

    @RequestMapping("/welcome/greeting")
    public String greeting() {
        return "welcome";
    }
}
