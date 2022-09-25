package com.project.agency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="Cabin")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cabin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCabin")
    private Long idCabin;

    @Column(name = "cabinName")
    private String cabinName;

    @Temporal(TemporalType.DATE)
    @Column(name="startDate")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="endDate")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(name="availability")
    private Availability availability;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "price")
    private float price;

    @Enumerated(EnumType.STRING)
    @Column(name="subCategory")
    private SubCategory subCategory;

    @ManyToOne
    @JsonIgnore
    private Reservation reservation;

    @ManyToOne
    private Deck deck;

}
