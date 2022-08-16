package com.project.agency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@Data
@DiscriminatorValue("LuxuryCabin")
public class LuxuryCabin extends Cabin{

    private String subCategory;
    private int capacity;
    private int quantity;

    @ManyToOne
    @JsonIgnore
    private Deck deck;

}
