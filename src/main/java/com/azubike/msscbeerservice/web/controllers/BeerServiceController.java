package com.azubike.msscbeerservice.web.controllers;

import com.azubike.msscbeerservice.services.BeerService;
import com.azubike.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/beer")
public class BeerServiceController {
  private final BeerService beerService;

  @GetMapping(value = "/{beerId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
    BeerDto beerDto = beerService.getBeerById(beerId);
    return ResponseEntity.ok(beerDto);
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
    BeerDto savedBeer = beerService.saveNewBeer(beerDto);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{beerId}")
            .buildAndExpand(savedBeer.getId())
            .toUri();
    return ResponseEntity.created(location).body(savedBeer);
  }

  @PutMapping(
      value = "/{beerId}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BeerDto> updateBeerById(
      @PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
    BeerDto updateBeer = beerService.updateBeer(beerId, beerDto);
    return ResponseEntity.ok(updateBeer);
  }

  @DeleteMapping(value = "/{beerId}")
  public void deleteBeerById(@PathVariable("beerId") UUID beerId) {
    beerService.deleteBeer(beerId);
  }
}
