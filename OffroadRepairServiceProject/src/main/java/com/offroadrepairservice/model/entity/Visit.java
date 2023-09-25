package com.offroadrepairservice.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Visit extends BaseEntity {

    @Column(nullable = false)
    private String carMake;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private String licensePlate;

    @Column
    private LocalDate dateReserved;


    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "visits_parts",
            joinColumns = @JoinColumn(name = "fk_visit"),
            inverseJoinColumns = @JoinColumn(name = "fk_part"))
    private List<Part> reservedParts;

    @Column
    private Long totalTime;

    @Column
    private BigDecimal totalPrice;

    public Visit(){

    }


    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Part> getReservedParts() {
        return reservedParts;
    }

    public void setReservedParts(List<Part> reservedParts) {
        this.reservedParts = reservedParts;
    }
}
