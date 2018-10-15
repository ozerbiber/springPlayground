package com.ozer.deneme.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;

@Entity
@Data
@SuppressWarnings("unused")
@DynamicUpdate
public class TestModel extends BasicEntity{
    private String name;
    private String age;
    private String adress;
}
