package com.codeup.zenithspringadlister.controller;

import com.codeup.zenithspringadlister.Repository.UserRepository;
import com.codeup.zenithspringadlister.models.Ad;
import com.codeup.zenithspringadlister.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userDao;


    public UserController(UserRepository userDao) {
       this.userDao = userDao;
    }

    @GetMapping("/register")// gets you to the form
    public String showRegisterPage(){
        return "/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
        User user = new User(username, email, password);
        userDao.save(user);
        return "redirect:/ads";
    }

    @GetMapping("/user/{id}/ads")
    public String usersAds(@PathVariable long id, Model model){
        User user = userDao.findById(id);
        List<Ad> userAds =  user.getAds();
        model.addAttribute("userAds", userAds);
        return "/userAds";
    }

}
