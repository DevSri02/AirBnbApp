package com.example.AirBnbApp.strategy;

import com.example.AirBnbApp.entity.Inventory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class OccupancyPricingStrategy implements  PricingStrategy{

    public final PricingStrategy wrapped;

    @Override
    public BigDecimal calculatePrice(Inventory inventory)
    {
        BigDecimal price=wrapped.calculatePrice(inventory);


        double  occupancyRate=(double) inventory.getBookedCount()/inventory.getTotalCount();


        if(occupancyRate>0.8){    //Applies a 20% price increase when occupancy exceeds 80%.
            price=price.multiply(BigDecimal.valueOf(1.2));
        }


        return price;
    }


}
