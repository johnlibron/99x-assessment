package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/prices")
public class PriceController {


    @GetMapping(value = "calculate/{one_}")
    public ResponseEntity<String> calculate(@PathVariable("units") Integer units) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
