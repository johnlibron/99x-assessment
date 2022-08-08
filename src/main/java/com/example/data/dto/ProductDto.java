package com.example.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Incoming DTO to create a new record of {@link com.example.data.model.Product}
 *
 * @author John James Libron
 */
@Data
public class ProductDto {

    @JsonProperty(required = true)
    @NotEmpty(message = "Name must not be empty.")
    private String name;

    @JsonProperty(required = true)
    @NotNull(message = "Units per carton must be specified.")
    private Integer unitsPerCarton;

    @JsonProperty(required = true)
    @NotNull(message = "Carton price must be specified.")
    private Integer cartonPrice;
}
