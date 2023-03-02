package com.azubike.msscbeerservice.services;

import com.azubike.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
  BeerDto getBeerById(UUID beerId);

  BeerDto saveNewBeer(BeerDto beerDto);

  BeerDto updateBeer(UUID beerId, BeerDto beerDto);

  void deleteBeer(UUID beerId);
}
