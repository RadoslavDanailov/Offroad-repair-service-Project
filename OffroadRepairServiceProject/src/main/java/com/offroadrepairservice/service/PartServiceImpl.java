package com.offroadrepairservice.service;

import com.offroadrepairservice.model.dto.AddPartDTO;
import com.offroadrepairservice.model.dto.PartDTO;
import com.offroadrepairservice.model.entity.Part;
import com.offroadrepairservice.model.entity.PartTypes;
import com.offroadrepairservice.model.entity.Type;
import com.offroadrepairservice.repo.PartRepo;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PartServiceImpl {
    private PartRepo repo;
    private TypeService typeService;

    public PartServiceImpl(PartRepo repo, TypeService typeService) {
        this.repo = repo;
        this.typeService = typeService;
    }

    public void addPart(AddPartDTO addPartDTO){
        this.repo.save(this.mapPart(addPartDTO));
    }

    public Part findPartById(Long id){
        return this.repo.findById(id).orElseThrow();
    }

    public PartDTO findPartByManufacturer(String manufacturer) {
        Part part = this.repo.findByManufacturer(manufacturer).orElse(null);
        if (part == null) {
            return null;
        }
        return this.mapPartDTO(part);
    }

    public Set<PartDTO> findPartsByType(Type type){
        return this.repo.findPartByType(type).
                stream().map(this::mapPartDTO).
                collect(Collectors.toSet());
    }

    public Set<PartDTO>getCart(Long id){
        return this.repo.findAllByUserId(id).  //checked in repo
                stream().
                map(this::mapPartDTO).
                collect(Collectors.toSet());
    }

    private PartDTO mapPartDTO(Part part) {
        PartDTO partDTO = new PartDTO();
        partDTO.setId(part.getId());
        partDTO.setManufacturer(part.getManufacturer());
        partDTO.setPartName(part.getPartName());
        partDTO.setTimeNeededToChange(part.getTimeNeededToChange());
        partDTO.setPrice(part.getPrice());
        return partDTO;
    }

    private Part mapPart(AddPartDTO addPartDTO){
        Part part = new Part();
        Type type = this.typeService.findType(addPartDTO.getType());

        part.setTimeNeededToChange(addPartDTO.getTimeNeededToChange());
        part.setPartName(addPartDTO.getPartName());
        part.setManufacturer(addPartDTO.getManufacturer());
        part.setType(type);
        part.setPrice(addPartDTO.getPrice());
        part.setManufacturingDate(addPartDTO.getManufacturingDate());

        return part;
    }
}
