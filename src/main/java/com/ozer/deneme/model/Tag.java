package com.ozer.deneme.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@SuppressWarnings("unused")
public class Tag extends BasicEntity{
    private String name;

}
