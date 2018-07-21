package com.example.form.web;

import com.example.form.dao.UserDao;
import com.example.form.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserFormValidator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model){
        model.addAttribute("users", userDao.findAll());
        return "users/list";
    }
}
