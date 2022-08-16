package com.project.agency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

enum Availability
{
    NOTAVAILABLE, AVAILABLE, MAINTENANCE
}

@Entity
@Table(name="Cabin")
@Data
public abstract class Cabin implements Serializable {

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

}
