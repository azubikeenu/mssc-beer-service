package com.azubike.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BeerDto {
  private UUID id;
  private String beerName;
  private Integer version;
  private Long upc;
  private BigDecimal price;
  private Integer quantityOnHand;
  private OffsetDateTime createdDate;
  private OffsetDateTime lastModifiedDate;
  private BeerStyle beerStyle;
}
