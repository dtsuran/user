package com.example.form.web;

import com.example.form.dao.UserDao;
import com.example.form.model.User;
import com.example.form.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.*;

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

    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {

        User user = new User();

        // set default value
        user.setName("mkyong123");
        user.setEmail("test@gmail.com");
        user.setAddress("abc 88");
        user.setNewsletter(true);
        user.setSex("M");
        user.setFramework(new ArrayList<>(Arrays.asList("Spring MVC", "GWT")));
        user.setSkill(new ArrayList<>(Arrays.asList("Spring", "Grails", "Groovy")));
        user.setCountry("SG");
        user.setNumber(2);
        model.addAttribute("userForm", user);

        populateDefaultModel(model);

        return "users/userform";
    }

    private void populateDefaultModel(Model model) {

        List<String> frameworksList = new ArrayList<>();
        frameworksList.add("Spring MVC");
        frameworksList.add("Struts 2");
        frameworksList.add("JSF 2");
        frameworksList.add("GWT");
        frameworksList.add("Play");
        frameworksList.add("Apache Wicket");
        model.addAttribute("frameworkList", frameworksList);

        List<String> skill = new ArrayList<>();
        skill.add("Hibernate");
        skill.add("Spring");
        skill.add("Struts");
        skill.add("Groovy");
        skill.add("Grails");
        model.addAttribute("javaSkillList", skill);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        model.addAttribute("numberList", numbers);

        Map<String, String> country = new LinkedHashMap<>();
        country.put("US", "United Stated");
        country.put("CN", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");
        model.addAttribute("countryList", country);
    }
}
