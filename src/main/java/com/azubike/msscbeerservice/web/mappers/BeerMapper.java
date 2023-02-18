package com.azubike.msscbeerservice.web.mappers;

import com.azubike.msscbeerservice.domain.Beer;
import com.azubike.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})

public interface BeerMapper {
  BeerDto beerToDto(Beer beer);

  Beer dtoToBeer(BeerDto beerDto);
}
