package com.ozer.deneme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@SuppressWarnings("unused")
public class DeveloperPaymentInformation extends BasicEntity {
    private String name;
    private String iban;
    private String taxNo;

}
