package com.example.service;

import com.example.data.dto.PriceDto;
import com.example.data.dto.PurchaseDto;

public interface CalculationService {

    PriceDto calculatePurchasePrice(Integer cartonPrice, PurchaseDto purchaseDto);
}
