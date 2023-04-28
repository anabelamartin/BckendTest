package com.example.prices.controller.implement;

import com.example.prices.controller.PriceController;
import com.example.prices.dto.PriceDTO;
import com.example.prices.services.implement.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
@RequestMapping("/price")
public class PriceControllerImpl implements PriceController {

    @Autowired
    private PriceServiceImpl priceService;

    @GetMapping("/product")
    public PriceDTO getPrice(@RequestParam Long brandId,
                             @RequestParam Long productId,
                             @RequestParam Date date) {
        priceService.init();

        return priceService.findPrice(brandId, productId, date);

    }
}
