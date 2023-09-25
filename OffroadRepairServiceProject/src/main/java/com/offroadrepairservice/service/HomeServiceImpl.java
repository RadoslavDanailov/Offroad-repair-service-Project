package com.offroadrepairservice.service;

import com.offroadrepairservice.model.dto.PartDTO;
import com.offroadrepairservice.model.dto.PartsByTypeDTO;
import com.offroadrepairservice.model.dto.VisitDTO;
import com.offroadrepairservice.model.entity.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class HomeServiceImpl {

    private final PartServiceImpl partService;
    private final TypeService typeService;
    private final UserServiceImpl userService;
    private final VisitServiceImpl visitService;



    public HomeServiceImpl(PartServiceImpl partService, TypeService typeService, UserServiceImpl userService, VisitServiceImpl visitService) {
        this.partService = partService;
        this.typeService = typeService;
        this.userService = userService;
        this.visitService = visitService;
    }

    public PartsByTypeDTO getParts(){
        PartsByTypeDTO parts = new PartsByTypeDTO();
        parts.setBodyParts(this.getPartsByType(this.typeService.findTypeByTypeName(PartTypes.BODY)));
        parts.setEngineParts(this.getPartsByType(this.typeService.findTypeByTypeName(PartTypes.ENGINE)));
        parts.setSuspensionParts(this.getPartsByType(this.typeService.findTypeByTypeName(PartTypes.SUSPENSION)));
        return parts;
    }

    public void addPart(Long partId, Long userId){
        Part part = this.partService.findPartById(partId);
        this.userService.addPartToUser(userId, part);
    }

    public void removePart(Long partId, Long userId){
        this.userService.removePartFromUser(userId, partId);
    }

    public void deleteAll(Long userId){
        this.userService.deleteAllParts(userId);
    }

    public Set<PartDTO>getPartsByType(Type type){
        return this.partService.findPartsByType(type);
    }

    public Long getSumTimeNeededToChange(Long userId){
            return this.userService.sumTimeNeededToChange(userId);
    }

    public BigDecimal getTotalPrice(Long userId){
        return this.userService.sumTotalPrice(userId);
    }

}
