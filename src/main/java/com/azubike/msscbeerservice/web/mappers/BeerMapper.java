package com.azubike.msscbeerservice.web.mappers;

import com.azubike.msscbeerservice.domain.Beer;
import com.azubike.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
  BeerDto beerToDto(Beer beer);

  @Mapping(target = "quantityToBrew", ignore = true)
  Beer dtoToBeer(BeerDto beerDto);
}
