package com.example.service.impl;

import com.example.data.dto.PriceDto;
import com.example.data.dto.PurchaseDto;
import com.example.data.model.Product;
import com.example.data.dto.ProductDto;
import com.example.data.repository.PriceRepository;
import com.example.data.repository.ProductRepository;
import com.example.service.CalculationService;
import com.example.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(CalculationService calculationService, ProductRepository productRepository) {
        this.calculationService = calculationService;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product productEntity = new Product();
        BeanUtils.copyProperties(productDto, productEntity);
        boolean isExists = productRepository.exists(Example.of(productEntity));
        if (isExists) {
            return null;
        }
        productRepository.save(productEntity);
        return productDto;
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    @Override
    public PriceDto purchaseProduct(Integer cartonPrice, PurchaseDto purchaseDto) {
        return calculationService.calculatePurchasePrice(cartonPrice, purchaseDto);
    }
}
