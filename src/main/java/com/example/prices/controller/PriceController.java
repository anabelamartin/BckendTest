package com.example.prices.controller;

import com.example.prices.dto.PriceDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;

public interface PriceController {

     PriceDTO getPrice(@RequestParam("brandId") Long brandId,
                                       @RequestParam("productId") Long productId,
                                       @RequestParam("date") Date date);
}
