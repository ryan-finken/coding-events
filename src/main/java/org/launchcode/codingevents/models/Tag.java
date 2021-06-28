package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tag extends AbstractEntity {

    @Size(max = 50, message = "Must not exceed 50 characters.")
    @NotNull(message = "Name is required.")
    @NotBlank(message = "Name is required.")
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return "#" + name;
    }
}
