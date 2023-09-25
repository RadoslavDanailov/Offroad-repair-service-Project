package com.offroadrepairservice.controller;

import com.offroadrepairservice.model.dto.AddPartDTO;
import com.offroadrepairservice.service.PartServiceImpl;
import com.offroadrepairservice.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PartControllerImpl implements PartController{

    private final LoggedUser loggedUser;
    private final PartServiceImpl partService;

    public PartControllerImpl(LoggedUser loggedUser, PartServiceImpl partService) {
        this.loggedUser = loggedUser;
        this.partService = partService;
    }

    @Override
    public String addPart() {
        if (!loggedUser.isLogged()){
            return "redirect:/users/login";
        }
        return "parts-add";
    }

    @Override
    public String addPart(AddPartDTO addPartDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()){
            redirectAttributes.
                    addFlashAttribute("addPartDTO", addPartDTO).
                    addFlashAttribute("org.springframework.validation.BindingResult.addPartDTO", result);
                                                 //BindingResult.MODEL_KEY_PREFIX + "addPartDTO", result
            return "redirect:/parts/add-part";
        }
        this.partService.addPart(addPartDTO);
        return "redirect:/home";
    }

    @ModelAttribute
    public AddPartDTO addPartDTO(){
        return new AddPartDTO();
    }
}
