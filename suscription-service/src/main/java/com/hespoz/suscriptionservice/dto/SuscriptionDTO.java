package com.hespoz.suscriptionservice.dto;

import com.hespoz.suscriptionservice.enums.Gender;

import javax.validation.constraints.NotNull;

/**
 * Created by hespoz on 3/10/18.
 */
public class SuscriptionDTO {

    @NotNull(message = "Email is required")
    private String email;

    private String firstName;

    private Gender gender;

    @NotNull(message = "Date of birth is required")
    private String dateOfBirth;

    @NotNull(message = "Flag is required")
    private Boolean flag;

    public SuscriptionDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
    
}
