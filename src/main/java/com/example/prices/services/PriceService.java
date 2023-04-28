package com.example.prices.services;

import com.example.prices.dto.PriceDTO;

import java.util.Date;

public interface PriceService {

    public PriceDTO findPrice(Long brandId, Long productId, Date date);

    public void init();

}
