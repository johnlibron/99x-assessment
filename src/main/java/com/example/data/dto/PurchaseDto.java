package com.example.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Purchase a product by category
 *
 * @author John James Libron
 */
@Data
public class PurchaseDto {

    @JsonProperty(required = true)
    @NotNull(message = "Purchase category must be specified.")
    private PurchaseCategory purchaseCategory;

    @JsonProperty(required = true)
    @NotNull(message = "Quantity must be specified.")
    private Integer quantity;
}
