package com.example.prices.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class PriceDTO {

    private Long productId;

    private Long brandId;

    private Integer priceList;

    private Date startDate;;

    private Date endDate;

    private BigDecimal price;

    private String currency;


    public PriceDTO(Long productId, Long brandId, Integer priceList, Date startDate, Date endDate, BigDecimal price, String currency) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currency = currency;
    }

    public PriceDTO() {
    }
}
