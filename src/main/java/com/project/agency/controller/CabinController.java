package com.project.agency.controller;

import com.project.agency.entities.Cabin;
import com.project.agency.services.CabinInter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/Cabin")
public class CabinController {

    @Autowired
    private CabinInter cabinService;

    @SneakyThrows
    @GetMapping("/FindCabins")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Cabin> findCabins (@RequestParam("arrive") String arrive, @RequestParam("leave") String leave, @RequestParam("passengers") int passengers)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date arriveD = formatter.parse(arrive);
        Date leaveD = formatter.parse(arrive);
        return cabinService.findCabins(arriveD, leaveD, passengers);
    }
}
