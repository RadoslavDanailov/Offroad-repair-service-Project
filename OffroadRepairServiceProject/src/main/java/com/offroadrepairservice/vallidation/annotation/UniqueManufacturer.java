package com.offroadrepairservice.vallidation.annotation;

import com.offroadrepairservice.vallidation.UniqueManufacturerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueManufacturerValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueManufacturer {
    String message()
            default "Manufacturer already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
