package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity {

    @Size(max = 500, message = "Description is too long!")
    private String description;

    @Email(message = "Not a valid email address.")
    @NotBlank(message = "Email is required.")
    private String contactEmail;

    @NotBlank(message = "Location is required.")
    @NotNull(message = "Location may not be null.")
    private String location;

    public EventDetails(String description, String contactEmail, String location) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
    }

    public EventDetails() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
