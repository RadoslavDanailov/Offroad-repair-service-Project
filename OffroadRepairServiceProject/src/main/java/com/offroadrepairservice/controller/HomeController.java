package com.offroadrepairservice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(name = "/")
public interface HomeController {

    @GetMapping
    String index();

    @GetMapping("/home")
    String home(Model model);

    @GetMapping("/home/add-part-to-cart/{id}")
    String addPartToCart(@PathVariable("id") Long id);


    @GetMapping("/home/remove-part-from-cart/{id}")
    String removePartFromCart(@PathVariable("id") Long id);


    @GetMapping("/home/remove-all-parts-from-cart")
    String deleteAllFromCart();


}
