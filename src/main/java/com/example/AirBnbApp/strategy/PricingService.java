package com.example.AirBnbApp.strategy;


import com.example.AirBnbApp.entity.Inventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PricingService {


    public BigDecimal calculateDynamicPricing(Inventory inventory){

        PricingStrategy pricingStrategy=new BasePricingStrategy();

        //apply the addiditional strategy

        pricingStrategy =new SurgePricingStrategy(pricingStrategy);
        pricingStrategy =new UrgencyPricingStrategy(pricingStrategy);
        pricingStrategy =new HolidayPricingStrategy(pricingStrategy);



        return pricingStrategy.calculatePrice(inventory);
    }

}
