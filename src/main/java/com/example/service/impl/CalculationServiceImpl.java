package com.example.service.impl;

import com.example.data.dto.PriceDto;
import com.example.data.dto.PurchaseCategory;
import com.example.data.dto.PurchaseDto;
import com.example.service.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    @Override
    public PriceDto calculatePurchasePrice(Integer cartonPrice, PurchaseDto purchaseDto) {
        PurchaseCategory purchaseCategory = purchaseDto.getPurchaseCategory();
        if (PurchaseCategory.UNITS.equals(purchaseCategory)) {
            // If you purchase single units, the price is acquired using the
            // carton price multiplied by an increase of 30% (1.3). (to compensate for manual labor)
            return cartonPrice;
        } else if (PurchaseCategory.CARTON.equals(purchaseCategory)) {
            if (purchaseDto.getQuantity() >= 3) {

            }
            // If you purchase 3 cartons or more, you will receive a 10% discount off the carton price
            return null;
        }
        return null;
    }
}
