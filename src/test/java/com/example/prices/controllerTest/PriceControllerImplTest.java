package com.example.prices.controllerTest;

import com.example.prices.controller.implement.PriceControllerImpl;
import com.example.prices.dto.PriceDTO;
import com.example.prices.services.implement.PriceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceControllerImpl.class)
public class PriceControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceServiceImpl priceService;

    PriceDTO product1 = new PriceDTO(35455L, 1L, 1,  new Date(120, Calendar.JUNE, 14, 0, 0, 0),new Date(120, Calendar.DECEMBER, 31, 23, 59, 59),BigDecimal.valueOf(35.50), "EUR");
    PriceDTO product2 = new PriceDTO(35455L,1L ,2 , new Date(120, Calendar.JUNE, 14, 15, 0, 0),new Date(120, Calendar.JUNE, 14, 18, 30, 0),BigDecimal.valueOf(25.45),"EUR");
    PriceDTO product3 = new PriceDTO(35455L,1L,3,  new Date(120, Calendar.JUNE, 15, 0, 0, 0), new Date(120, Calendar.JUNE, 15, 11, 0, 0),BigDecimal.valueOf(30.50), "EUR");
    PriceDTO product4 = new PriceDTO(35455L,1L,4, new Date(120, Calendar.JUNE, 15, 16, 0, 0), new Date(120, Calendar.DECEMBER, 31, 23, 59, 59),BigDecimal.valueOf(38.95), "EUR");

    @Test
    void testGetPrice1() throws Exception {

        when(priceService.findPrice(any(), any(), any())).thenReturn(product1);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/price/product")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("date", "2020/06/14 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(product1.getPriceList()));

    }
    @Test
    void testGetPrice2() throws Exception {

        when(priceService.findPrice(any(), any(), any())).thenReturn(product1);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/price/product")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("date", "2020/06/14 16:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(product1.getPriceList()));

    }
    @Test
    void testGetPrice3() throws Exception {

        when(priceService.findPrice(any(), any(), any())).thenReturn(product2);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/price/product")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("date", "2020/06/14 21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(product2.getPriceList()));

    }
    @Test
    void testGetPrice4() throws Exception {

        when(priceService.findPrice(any(), any(), any())).thenReturn(product3);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/price/product")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("date", "2020/06/15 10:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(product3.getPriceList()));

    }

    @Test
    void testGetPrice5() throws Exception {

        when(priceService.findPrice(any(), any(), any())).thenReturn(product4);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/price/product")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("date", "2020/06/16 21:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(product4.getPriceList()));

    }

}