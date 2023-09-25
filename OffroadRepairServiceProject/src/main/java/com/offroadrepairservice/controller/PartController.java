package com.offroadrepairservice.controller;

import com.offroadrepairservice.model.dto.AddPartDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/parts")
public interface PartController {

    @GetMapping("add-part")
    String addPart();

    @PostMapping("/add-part")
    String addPart(@Valid AddPartDTO addPartDTO, BindingResult result, RedirectAttributes redirectAttributes);

}
