package com.offroadrepairservice.model.dto;

import java.util.Set;

public class PartsByTypeDTO {
    private Set<PartDTO>engineParts;
    private Set<PartDTO>suspensionParts;
    private Set<PartDTO>bodyParts;
    public PartsByTypeDTO() {
    }

    public Set<PartDTO> getEngineParts() {
        return engineParts;
    }

    public void setEngineParts(Set<PartDTO> engineParts) {
        this.engineParts = engineParts;
    }

    public Set<PartDTO> getSuspensionParts() {
        return suspensionParts;
    }

    public void setSuspensionParts(Set<PartDTO> suspensionParts) {
        this.suspensionParts = suspensionParts;
    }

    public Set<PartDTO> getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(Set<PartDTO> bodyParts) {
        this.bodyParts = bodyParts;
    }
}
