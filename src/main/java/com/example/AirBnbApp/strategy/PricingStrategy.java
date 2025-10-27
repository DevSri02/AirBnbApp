package com.example.AirBnbApp.strategy;


import com.example.AirBnbApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);


}
