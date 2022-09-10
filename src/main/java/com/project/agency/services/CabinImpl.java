package com.project.agency.services;

import com.project.agency.entities.Cabin;
import com.project.agency.entities.SubCategory;
import com.project.agency.repositories.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CabinImpl implements CabinInter{

    @Autowired
    private CabinRepository cabinRepo;

    @Override
    public List<Cabin> findCabins(Date arriveDate, Date leaveDate, int passengerNum, String category) {

        SubCategory cat = null;

        if(category.equalsIgnoreCase(SubCategory.FOURPAOUTSIDE.toString()))
        {
            cat = SubCategory.FOURPAOUTSIDE;
        }
        else if (category.equalsIgnoreCase(SubCategory.FOURPAINSIDE.toString()))
        {
            cat = SubCategory.FOURPAINSIDE;
        }
        else if (category.equalsIgnoreCase(SubCategory.TWOPBOUTSIDE.toString()))
        {
            cat = SubCategory.TWOPBOUTSIDE;
        }
        else if (category.equalsIgnoreCase(SubCategory.TWOPAINSIDE.toString()))
        {
            cat = SubCategory.TWOPAINSIDE;
        }
        else if (category.equalsIgnoreCase(SubCategory.HDCOUTSIDE.toString()))
        {
            cat = SubCategory.HDCOUTSIDE;
        }
        else if (category.equalsIgnoreCase(SubCategory.ANTIALLERGYINSIDE.toString()))
        {
            cat = SubCategory.ANTIALLERGYINSIDE;
        }
        else if (category.equalsIgnoreCase(SubCategory.LUXURYCABIN.toString()))
        {
            cat = SubCategory.LUXURYCABIN;
        }
        else if (category.equalsIgnoreCase(SubCategory.ARMCHAIR.toString()))
        {
            cat = SubCategory.ARMCHAIR;
        }

        return cabinRepo.findCabins(arriveDate, passengerNum, cat);
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

    @Override
    public List<Cabin> cabinsInCart(Long[] listIdCabin) {

        List<Long> myCabins = new ArrayList<>(Arrays.asList(listIdCabin));
        return cabinRepo.findAllById(myCabins);
    }

}
