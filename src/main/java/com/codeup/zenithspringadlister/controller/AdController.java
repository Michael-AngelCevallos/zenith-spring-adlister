package com.codeup.zenithspringadlister.controller;


import com.codeup.zenithspringadlister.Repository.AdRepository;
import com.codeup.zenithspringadlister.Repository.TagRepository;
import com.codeup.zenithspringadlister.Repository.UserRepository;
import com.codeup.zenithspringadlister.models.Ad;
import com.codeup.zenithspringadlister.models.User;
import com.codeup.zenithspringadlister.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdController {
    private final AdRepository adsDao;
    private final UserRepository userDao;
    private final TagRepository tagDao;


    public AdController(AdRepository adsDao, UserRepository userDao, TagRepository tagDao){
        this.adsDao = adsDao;
        this.userDao = userDao; // gives Adcontroller access to the usersDao
        this.tagDao = tagDao;
    }

    @GetMapping("/ads")
    public String allAds(Model model){
        model.addAttribute("ads", adsDao.findAll());
        return "/ads/index";
    }

    @GetMapping("/ads/create")
    public String postAdForm(){
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String postAd(@RequestParam(name="title") String title, @RequestParam(name="description") String description){
//        User user = userDao.findById(1);// this is a hard coded way of adding a user id when you create an ad

        //Or you can use this to create a random user everytime you create a new ad
        User user = Users.randomUser(userDao);
        Ad ad = new Ad(title, description, user);
        adsDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("/ads/{id}")
    public String showOneAd(@PathVariable long id, Model model){
        Ad ad = adsDao.findById(id);// this will have red squiggly lines if you don't add --> Ad findById(long id); <--- to your AdRepository
        model.addAttribute(ad == null? new Ad("not found", "Could not find that ad") : ad);
        return "/ads/show";
    }


}