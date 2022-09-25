package com.project.agency.services;


import com.project.agency.entities.Availability;
import com.project.agency.entities.Cabin;
import com.project.agency.entities.Reservation;
import com.project.agency.repositories.CabinRepository;
import com.project.agency.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class ReservationImpl implements ReservationInter{

    @Autowired
    private ReservationRepository reservationRepo;

    @Autowired
    private CabinRepository cabinRepo;


    @Override
    public Reservation addReservation(Reservation R, Long[] listCabins) {

        LocalDate localDate = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date today = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        List<Long> cabinIds = new ArrayList<>();
        for(Long x : listCabins)
        {
            cabinIds.add(x);
        }
        cabinIds.forEach( x -> System.out.println(x));//test
        List<Cabin> myCabins = cabinRepo.findAllById(cabinIds);
        Set<Cabin> cabins = new HashSet<>(myCabins);
        myCabins.forEach( x -> System.out.println(x.getCabinName()));//test
        R.setReservationCabins(cabins);
        R.setReservationDate(today);
        reservationRepo.save(R);
        //cabins.forEach( C -> C.setReservation(R));
        cabins.forEach( C -> {
            C.setReservation(R);
            C.setStartDate(R.getCheckIn());
            C.setEndDate(R.getCheckOut());
            C.setAvailability(Availability.NOTAVAILABLE);
        });
        cabinRepo.saveAll(cabins);
        return R;
    }
}
