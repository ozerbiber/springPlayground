package com.ozer.deneme.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@SuppressWarnings("unused")
public class Education extends BasicEntity {
    private String schoolName;
    private Double gpa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developerId")
    @JsonBackReference
    private Developer developer;
}
