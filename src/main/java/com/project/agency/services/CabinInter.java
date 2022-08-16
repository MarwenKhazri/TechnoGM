package com.project.agency.services;

import com.project.agency.entities.Cabin;

import java.util.Date;
import java.util.List;

public interface CabinInter {

    List<Cabin> findCabins(Date arriveDate, Date leaveDate, int PassengerNum);

}
