package com.ozer.deneme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@SuppressWarnings("unused")
public class Proficiency extends BasicEntity {
    private int completedProjects;

}
