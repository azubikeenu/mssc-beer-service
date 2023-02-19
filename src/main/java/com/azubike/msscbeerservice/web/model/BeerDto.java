package com.azubike.msscbeerservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BeerDto {
  @Null private UUID id;
  @NotBlank private String beerName;
  @Null private Long version;
  @Positive @NotNull private Long upc;

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  @Positive
  @NotNull
  private BigDecimal price;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
  @Null
  private OffsetDateTime createdDate;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
  @Null
  private OffsetDateTime lastModifiedDate;

  @NotNull private BeerStyle beerStyle;
  private Integer quantityOnHand;
}
