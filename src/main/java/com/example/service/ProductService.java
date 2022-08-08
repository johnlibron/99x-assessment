package com.example.service;

import com.example.data.dto.PriceDto;
import com.example.data.dto.ProductDto;
import com.example.data.dto.PurchaseDto;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long id);

    PriceDto purchaseProduct(Integer cartonPrice, PurchaseDto purchaseDto);
}
