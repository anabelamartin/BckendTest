package com.example.prices.services.implement;

import com.example.prices.dto.PriceDTO;
import com.example.prices.model.PriceEntity;
import com.example.prices.repositories.PriceRepository;
import com.example.prices.services.PriceService;
import com.example.prices.services.exceptions.PriceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private ObjectMapper objectMapper;


    public PriceDTO findPrice(Long brandId, Long productId, Date date) {
        List<PriceEntity> prices = priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId, date,date);

        if (!prices.isEmpty()) {
            PriceEntity price = prices.get(0);
            return objectMapper.convertValue(price, PriceDTO.class);

        } else{
                throw new PriceNotFoundException("Price not found.");

        }
    }


    @Override
    public void init() {
        List<PriceEntity> prices = List.of(
                new PriceEntity(1L, new Date(120, Calendar.JUNE, 14, 0, 0, 0), new Date(120, Calendar.DECEMBER, 31, 23, 59, 59), 1, 35455L, 0, BigDecimal.valueOf(35.50), "EUR"),
                new PriceEntity(1L, new Date(120, Calendar.JUNE, 14, 15, 0, 0), new Date(120, Calendar.JUNE, 14, 18, 30, 0), 2, 35455L, 1, BigDecimal.valueOf(25.45), "EUR"),
                new PriceEntity(1L, new Date(120, Calendar.JUNE, 15, 0, 0, 0), new Date(120, Calendar.JUNE, 15, 11, 0, 0), 3, 35455L, 1, BigDecimal.valueOf(30.50), "EUR"),
                new PriceEntity(1L, new Date(120, Calendar.JUNE, 15, 16, 0, 0), new Date(120, Calendar.DECEMBER, 31, 23, 59, 59), 4, 35455L, 1, BigDecimal.valueOf(38.95), "EUR")
        );
        priceRepository.saveAll(prices);
    }


}

