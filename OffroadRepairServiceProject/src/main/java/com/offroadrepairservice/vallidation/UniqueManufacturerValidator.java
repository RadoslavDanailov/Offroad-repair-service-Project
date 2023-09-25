package com.offroadrepairservice.vallidation;

import com.offroadrepairservice.service.PartServiceImpl;
import com.offroadrepairservice.vallidation.annotation.UniqueManufacturer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueManufacturerValidator implements ConstraintValidator<UniqueManufacturer, String> {

    private final PartServiceImpl partService;

    public UniqueManufacturerValidator(PartServiceImpl partService){
        this.partService = partService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.partService.findPartByManufacturer(value) == null;
    }

}
