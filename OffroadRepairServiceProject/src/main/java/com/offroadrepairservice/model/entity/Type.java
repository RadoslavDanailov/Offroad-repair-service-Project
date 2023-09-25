package com.offroadrepairservice.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Type extends BaseEntity{

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PartTypes typeName;

    @Column
    private String description;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private Set<Part>partsByType;

    public Type() {
    }

    public PartTypes getTypeName() {
        return typeName;
    }

    public void setTypeName(PartTypes typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Part> getPartsByType() {
        return partsByType;
    }

    public void setPartsByType(Set<Part> partsByType) {
        this.partsByType = partsByType;
    }
}
