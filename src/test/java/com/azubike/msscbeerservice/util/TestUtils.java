package com.azubike.msscbeerservice.util;

import com.azubike.msscbeerservice.web.model.BeerDto;
import com.azubike.msscbeerservice.web.model.BeerStyle;

import java.math.BigDecimal;

public class TestUtils {
  public static BeerDto createValidBeerDto() {
    return BeerDto.builder()
        .beerName("PALE_ALE")
        .beerStyle(BeerStyle.ALE)
        .price(new BigDecimal("10.5"))
            .upc(1230300L)
        .quantityToBrew(10)
        .build();
  }
}
