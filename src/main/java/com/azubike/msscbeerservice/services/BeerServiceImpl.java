package com.azubike.msscbeerservice.services;

import com.azubike.msscbeerservice.domain.Beer;
import com.azubike.msscbeerservice.repositories.BeerRepository;
import com.azubike.msscbeerservice.web.controllers.exception.NotFoundException;
import com.azubike.msscbeerservice.web.mappers.BeerMapper;
import com.azubike.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {
  private final BeerRepository beerRepository;
  private final BeerMapper beerMapper;

  @Override
  public BeerDto getBeerById(UUID beerId) {
    return beerMapper.beerToDto(getBeer(beerId));
  }

  @Override
  public BeerDto saveNewBeer(BeerDto beerDto) {
    return beerMapper.beerToDto(beerRepository.save(beerMapper.dtoToBeer(beerDto)));
  }

  @Override
  public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
    Beer beer = getBeer(beerId);
    beer.setBeerName(beerDto.getBeerName());
    beer.setBeerStyle(beerDto.getBeerStyle().name());
    beer.setPrice(beerDto.getPrice());
    beer.setUpc(beerDto.getUpc());

    return beerMapper.beerToDto(beerRepository.save(beer));
  }

  @Override
  public void deleteBeer(UUID beerId) {
    beerRepository.delete(getBeer(beerId));
  }

  private Beer getBeer(UUID beerId) {
    return beerRepository
        .findById(beerId)
        .orElseThrow(() -> new NotFoundException(beerId + ", Not Found."));
  }
}
