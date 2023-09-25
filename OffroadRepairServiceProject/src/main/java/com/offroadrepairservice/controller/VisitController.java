package com.offroadrepairservice.controller;

import com.offroadrepairservice.model.dto.VisitDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/visits")
public interface VisitController {

    @GetMapping("add-visit")
    String addVisit();

    @PostMapping("/add-visit")
    String addVisit(@Valid VisitDTO visitDTO, BindingResult result, RedirectAttributes redirectAttributes);

    @GetMapping("check-visit")
    String checkVisit();

    @PostMapping("/check-visit")
    String checkVisit(@RequestParam("licensePlate") String licensePlate, Model model);

}
