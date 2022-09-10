package com.project.agency.controller;


import com.project.agency.entities.Reservation;
import com.project.agency.services.ReservationInter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/Reservation")
public class ReservationController {

    @Autowired
    private ReservationInter reservationService;

    @SneakyThrows
    @PostMapping("/MakeReservation/{idCabins}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Reservation create(@RequestBody Reservation R, @PathVariable Long[] idCabins)
    {
        System.out.println(idCabins.length);
        return reservationService.addReservation(R, idCabins);
    }


}
