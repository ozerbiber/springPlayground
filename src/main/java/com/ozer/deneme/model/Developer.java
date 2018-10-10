package com.ozer.deneme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "developers")
@Data
@SuppressWarnings("unused")
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
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "developer_tags",
            joinColumns = @JoinColumn(name = "developerId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tagId", referencedColumnName = "id")
    )
    private Set<Tag> tags;
    private String surname;
}
