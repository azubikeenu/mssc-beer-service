package com.azubike.msscbeerservice.util;
import com.azubike.msscbeerservice.web.model.BeerDto;
import com.azubike.msscbeerservice.web.model.BeerStyle;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class TestUtils {
  public static BeerDto createValidBeerDto() {
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .beerName("PALE_ALE")
        .version(1L)
        .beerStyle(BeerStyle.ALE)
        .price(new BigDecimal("10.5"))
        .upc(1230300L)
        .createdDate(OffsetDateTime.now())
        .lastModifiedDate(OffsetDateTime.now())
        .quantityOnHand(10)
        .build();
  }

  public static BeerDto createBeerDto() {
    return BeerDto.builder()
        .beerName("PALE_ALE")
        .beerStyle(BeerStyle.ALE)
        .price(new BigDecimal("10.5"))
        .upc(1230300L)
        .quantityOnHand(10)
        .build();
  }
}
