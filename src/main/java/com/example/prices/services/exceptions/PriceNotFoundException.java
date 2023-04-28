package com.example.prices.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PriceNotFoundException extends RuntimeException{

    public PriceNotFoundException (String message){
        super(message);
    }
}
