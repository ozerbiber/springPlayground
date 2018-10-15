package com.ozer.deneme.model;

import lombok.Data;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name="developers")
@Data
@SuppressWarnings("unused")
public class DeveloperBase extends BasicEntity{
    private String name;
    private Double rateAvg;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "availabilityId")
    private Availability availability;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proficiencyId")
    private Proficiency proficiency;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tag;

}
