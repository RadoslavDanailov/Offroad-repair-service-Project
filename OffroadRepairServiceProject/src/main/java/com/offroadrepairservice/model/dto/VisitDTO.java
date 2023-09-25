package com.offroadrepairservice.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class VisitDTO {

    private Long id;
    @Size(min = 3, max = 20)
    @NotNull
    private String carMake;
    @Size(min = 3, max = 20)
    @NotNull
    private String carModel;
    @Size(min = 3, max = 10)
    @NotNull
    private String licensePlate;
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateReserved;

    private Long userId;

    public VisitDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getDateReserved() {
        return dateReserved;
    }

    public void setDateReserved(LocalDate dateReserved) {
        this.dateReserved = dateReserved;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
