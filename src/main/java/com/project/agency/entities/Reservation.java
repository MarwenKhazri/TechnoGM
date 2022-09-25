package com.project.agency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

enum Restaurant {
    MENU,SELFSERVICE,ALACARTE,NONE
}



@Entity
@Table(name="Reservation")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Long idReservation;

    @Temporal(TemporalType.DATE)
    @Column(name = "reservationDate")
    private Date reservationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "checkIn")
    private Date checkIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "checkOut")
    private Date checkOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "restaurant")
    private Restaurant restaurant;

    @Column(name = "playRoom")
    private boolean playRoom;

    @Column(name = "meetingRoom")
    private boolean meetingRoom;

    @Column(name = "gameRoom")
    private boolean gameRoom;

    @Column(name = "jacuzzi")
    private boolean jacuzzi;

    @Column(name = "solarium")
    private boolean solarium;


    @OneToMany(mappedBy = "reservation")
    private Set<Cabin> reservationCabins;

    @Column(name = "totalPrice")
    private float totalPrice;
}
