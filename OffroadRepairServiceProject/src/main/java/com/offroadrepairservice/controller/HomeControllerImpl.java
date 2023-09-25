package com.offroadrepairservice.controller;

import com.offroadrepairservice.model.dto.PartsByTypeDTO;
import com.offroadrepairservice.service.HomeServiceImpl;
import com.offroadrepairservice.service.PartServiceImpl;
import com.offroadrepairservice.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;

@Controller
public class HomeControllerImpl implements HomeController {

    private final LoggedUser loggedUser;
    private final HomeServiceImpl homeService;
    private final PartServiceImpl partService;

    public HomeControllerImpl(LoggedUser loggedUser, HomeServiceImpl homeService, PartServiceImpl partService) {
        this.loggedUser = loggedUser;
        this.homeService = homeService;
        this.partService = partService;
    }

    @Override
    public String index() {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @Override
    public String home(Model model) {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        model.addAttribute("parts", this.homeService.getParts());
        model.addAttribute("cart", this.partService.getCart(loggedUser.getId()));

        Long totalTimeNeededToChange = this.homeService.getSumTimeNeededToChange(loggedUser.getId());
        model.addAttribute("totalTimeNeededToChange", totalTimeNeededToChange);

        BigDecimal totalPrice = this.homeService.getTotalPrice(loggedUser.getId());
        model.addAttribute("totalPrice", totalPrice);


        return "home";
    }

    @Override
    public String addPartToCart(Long id){
        if (!loggedUser.isLogged()){
            return "redirect:/users/login";
        }
        this.homeService.addPart(id, this.loggedUser.getId());   //this was missing
        return "redirect:/home";
    }


    @Override
    public String removePartFromCart(Long id){

        if (!loggedUser.isLogged()){
            return "redirect:/users/login";
        }
        this.homeService.removePart(id, this.loggedUser.getId());
        return "redirect:/home";
    }


    @Override
    public String deleteAllFromCart(){
        if ((!loggedUser.isLogged())){
            return "redirect:/users/login";
        }
        this.homeService.deleteAll(this.loggedUser.getId());
        return "redirect:/home";
    }


    @ModelAttribute
    public PartsByTypeDTO parts() {
        return new PartsByTypeDTO();
    }


}
