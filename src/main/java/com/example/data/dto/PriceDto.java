package com.example.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Incoming DTO to create a new record of {@link com.example.data.model.Price}
 *
 * @author John James Libron
 */
@Data
public class PriceDto {

    @JsonProperty(required = true)
    @NotNull(message = "Carton must be specified.")
    private Integer carton;

    @JsonProperty(required = true)
    @NotNull(message = "Units must be specified.")
    private Integer units;

    public Integer getCarton() {
        return carton;
    }

    public void setCarton(Integer carton) {
        this.carton = carton;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }
}
