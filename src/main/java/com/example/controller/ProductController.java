package com.example.controller;

import com.example.data.dto.PriceDto;
import com.example.data.dto.ProductDto;
import com.example.data.dto.PurchaseCategory;
import com.example.data.dto.PurchaseDto;
import com.example.service.ProductService;
import com.example.service.CalculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author John James Libron
 */
@RestController
@RequestMapping(path = {"/api/v1/products"}, produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductController.class);

    private static final String ID = "orderId";
    private static final String NEW_PRODUCT_LOG = "New product was created id:{}";
    private static final String PRODUCT_UPDATED_LOG = "Order:{} was updated";

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Create a new product")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Product is created", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductDto.class))}),
        @ApiResponse(responseCode = "409", description = "Product already exists", content = @Content)
    })
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        final ProductDto createProduct = productService.createProduct(productDto);
        if (createProduct == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        logger.info(NEW_PRODUCT_LOG, createProduct.toString());
//        Map<String, String>
        HashMap<String, String> response = new HashMap<>();
//        return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
//        return new ResponseEntity<ProductDto>("", new HttpHeaders(), HttpStatus.CREATED);
        return null;
    }

    @Operation(summary = "Purchase a product by category")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Product is created", content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductDto.class))}),
        @ApiResponse(responseCode = "404", description = "Product does not exist", content = @Content)
    })
    @PostMapping(value = "{productId}/purchase", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDto> purchaseProduct(@PathVariable("productId") Long id, @Valid @RequestBody PurchaseDto purchaseDto) {
        final ProductDto product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        final PriceDto purchaseProduct = productService.purchaseProduct(product.getCartonPrice(), purchaseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
