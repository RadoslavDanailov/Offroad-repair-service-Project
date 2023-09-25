package com.offroadrepairservice.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Part extends BaseEntity{

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String partName;

    @Column
    private Long timeNeededToChange;

    @Column
    private LocalDate manufacturingDate;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_type")
    private Type type;

    @ManyToMany(mappedBy = "cart")
    private Set<User> user;

    @ManyToMany(mappedBy = "reservedParts")
    private Set<Visit> visit;

    public Part(){
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
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
    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Visit> getVisit() {
        return visit;
    }

    public void setVisit(Set<Visit> visit) {
        this.visit = visit;
    }
}
