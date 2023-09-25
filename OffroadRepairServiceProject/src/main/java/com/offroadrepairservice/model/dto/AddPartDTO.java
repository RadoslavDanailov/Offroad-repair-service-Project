package com.offroadrepairservice.model.dto;

import com.offroadrepairservice.model.entity.PartTypes;
import com.offroadrepairservice.model.entity.Type;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AddPartDTO {

    private Long id;

    @Size(min = 3, max = 20)
    @NotNull
    private String manufacturer;

    @Size(min = 2, max = 20)
    @NotNull
    private String partName;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufacturingDate;

    @Positive
    @NotNull
    private Long timeNeededToChange;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private PartTypes type;

    public AddPartDTO() {
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Long getTimeNeededToChange() {
        return timeNeededToChange;
    }

    public void setTimeNeededToChange(Long timeNeededToChange) {
        this.timeNeededToChange = timeNeededToChange;
    }

    public PartTypes getType() {
        return type;
    }

    public void setType(PartTypes type) {
        this.type = type;
    }


}
