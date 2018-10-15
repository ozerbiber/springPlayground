package com.ozer.deneme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "developers")
@DynamicUpdate
public class Developer extends BasicEntity{
    private String name;
    private Double rateAvg;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "availabilityId")
    private Availability availability;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "proficiencyId")
    private Proficiency proficiency;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "developerPaymentInformationId")
    private DeveloperPaymentInformation developerPaymentInformation;
    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "developer")
    @JsonManagedReference
    private Set<Education> education;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tag;
    private String surname;
    public Developer(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRateAvg() {
        return rateAvg;
    }

    public void setRateAvg(Double rateAvg) {
        this.rateAvg = rateAvg;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency proficiency) {
        this.proficiency = proficiency;
    }

    public DeveloperPaymentInformation getDeveloperPaymentInformation() {
        return developerPaymentInformation;
    }

    public void setDeveloperPaymentInformation(DeveloperPaymentInformation developerPaymentInformation) {
        this.developerPaymentInformation = developerPaymentInformation;
    }

    public Set<Education> getEducation() {
        return education;
    }

    public void setEducation(Set<Education> education) {
        this.education = education;
    }

    public Set<Tag> getTag() {
        return tag;
    }

    public void setTag(Set<Tag> tag) {
        this.tag = tag;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
