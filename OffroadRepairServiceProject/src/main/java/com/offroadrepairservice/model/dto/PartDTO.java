package com.offroadrepairservice.model.dto;

import java.math.BigDecimal;

public class PartDTO {
    private Long id;
    private String manufacturer;
    private String partName;
    private Long timeNeededToChange;
    private BigDecimal price;

    public PartDTO() {
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

    public Long getTimeNeededToChange() {
        return timeNeededToChange;
    }

    public void setTimeNeededToChange(Long timeNeededToChange) {
        this.timeNeededToChange = timeNeededToChange;
    }
}
