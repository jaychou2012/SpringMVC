package com.web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/p")
public class BaseController {
    @RequestMapping("/getPage")
    public String getPage(Model model) {
        return "view/index";
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page(Model model) {
        model.addAttribute("text", "This is MyTest page with Thymeleaf!");
        return "page";
    }
}
