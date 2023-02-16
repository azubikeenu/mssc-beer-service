package com.azubike.msscbeerservice.web.controllers;

import com.azubike.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/beer")
public class BeerServiceController {

  @GetMapping(value = "/{beerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
    // TODO IMPL
    return ResponseEntity.ok(BeerDto.builder().id(UUID.randomUUID()).build());
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto) {
    // TODO IMPL
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping(
      value = "/{beerId}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity updateBeerById(
      @PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
    // TODO IMPL
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{beerId}")
  public void deleteBeerById(@PathVariable("beerId") UUID beerId) {
    // TODO IMPL

  }
}
