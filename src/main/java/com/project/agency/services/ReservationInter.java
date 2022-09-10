package com.project.agency.services;

import com.project.agency.entities.Reservation;

import java.util.List;
import java.util.Set;

public interface ReservationInter {

    Reservation addReservation(Reservation R, Long[] listCabins);
}
