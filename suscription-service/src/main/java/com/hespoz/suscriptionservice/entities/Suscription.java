package com.hespoz.suscriptionservice.entities;

import com.hespoz.suscriptionservice.enums.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

/**
 * Created by hespoz on 3/9/18.
 */
@Entity
@Table(
        name = "suscription",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "email"}) }
)
public class Suscription {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();


    @Column(nullable = false)
    private String firstName;

    @Column(name="engine_type", nullable = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Column(nullable = false)
    @NotNull(message = "Email is mandatory!")
    private String email;


    @Column(nullable = false)
    @NotNull(message = "Date of birth is mandatory!")
    private String dateOfBirth;

    @Column(nullable = false)
    @NotNull(message = "Flag is mandatory!")
    private Boolean flag;

    public Suscription() {
    }

    public Suscription( String firstName, Gender gender, @NotNull(message = "Email is mandatory!") String email, @NotNull(message = "Date of birth is mandatory!") String dateOfBirth, @NotNull(message = "Flag is mandatory!") Boolean flag) {
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.flag = flag;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
