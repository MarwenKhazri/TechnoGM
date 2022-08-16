package com.project.agency.services;

import com.project.agency.entities.Cabin;
import com.project.agency.repositories.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CabinImpl implements CabinInter{

    @Autowired
    private CabinRepository cabinRepo;

    @Override
    public List<Cabin> findCabins(Date arriveDate, Date leaveDate, int PassengerNum) {

        return cabinRepo.findCabins(arriveDate);
    }
}
