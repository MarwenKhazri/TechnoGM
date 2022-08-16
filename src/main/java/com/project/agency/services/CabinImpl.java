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

    @Override
    public Cabin addCabin(Cabin C) {
        return cabinRepo.save(C);
    }

    @Override
    public Long removeCabin(Long idc) {
        cabinRepo.deleteById(idc);
        return idc;
    }


    @Override
    public Cabin updateCabin(Cabin C) {
        return cabinRepo.save(C);
    }
}
