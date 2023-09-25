package com.offroadrepairservice.controller;

import com.offroadrepairservice.model.dto.VisitDTO;
import com.offroadrepairservice.model.entity.Visit;
import com.offroadrepairservice.service.VisitServiceImpl;
import com.offroadrepairservice.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
public class VisitControllerImpl implements VisitController{

    private final LoggedUser loggedUser;

    private final VisitServiceImpl visitService;

    public VisitControllerImpl(LoggedUser loggedUser, VisitServiceImpl visitService) {
        this.loggedUser = loggedUser;
        this.visitService = visitService;
    }


    @Override
    public String addVisit() {
        if (!loggedUser.isLogged()){
            return "redirect:/users/login";
        }
        return "reserve-visit";
    }


    @Override
    public String addVisit(VisitDTO visitDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){
            redirectAttributes.
                    addFlashAttribute("visitDTO", visitDTO).
                    addFlashAttribute("org.springframework.validation.BindingResult.visitDTO", result);
            return "redirect:/visits/add-visit";
        }
        this.visitService.addVisit(visitDTO);
        return "redirect:/home";
    }

    @Override
    public String checkVisit(){
        if (!loggedUser.isLogged()){
            return "redirect:/users/login";
        }
        return "visit-check";
    }


    @Override
    public String checkVisit(@RequestParam("licensePlate") String licensePlate, Model model) {
        List<Visit> visits = visitService.findVisitByLicensePlate(licensePlate);

        if (visits.isEmpty()) {
            model.addAttribute("visits", Collections.emptyList());
            return "no-visit";
        } else if (visits.size() == 1) {
            model.addAttribute("visits", visits);
            return "visit-visual";
        } else {
            model.addAttribute("visits", visits);

            return "visit-visual";
        }
    }


    @ModelAttribute
    public VisitDTO visitDTO(){
        return new VisitDTO();
    }


}
