package com.ozer.deneme.model;

import lombok.Data;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

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
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "developer_tags",
            joinColumns = @JoinColumn(name = "developerId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tagId", referencedColumnName = "id")
    )
    private Set<Tag> tags;

}
