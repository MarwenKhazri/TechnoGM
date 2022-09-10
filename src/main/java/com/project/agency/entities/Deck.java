package com.project.agency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="Deck")
@Data
public class Deck implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDeck")
    private Long idDeck;

    @Column(name = "deckName")
    private String deckName;

    @Column(name = "deckNumber")
    private int deckNumber;

    @OneToMany(mappedBy = "deck")
    @JsonIgnore
    private Set<Cabin> listCabins;




}
