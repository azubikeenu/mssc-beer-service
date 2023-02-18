package com.azubike.msscbeerservice.bootstrap;

import com.azubike.msscbeerservice.domain.Beer;
import com.azubike.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Slf4j
public class BeerLoader implements CommandLineRunner {
  private final BeerRepository beerRepository;

  @Override
  public void run(String... args) throws Exception {
    loadBeers();
  }

  private void loadBeers() {
    if (beerRepository.count() == 0) {
      log.info("Creating new Instances of beers.......");
      beerRepository.save(
          Beer.builder()
              .beerName("Mango Bobs")
              .beerStyle("IPA")
              .quantityToBrew(300)
              .upc(230300000L)
              .price(new BigDecimal("12.50"))
              .build());

      beerRepository.save(
          Beer.builder()
              .beerName("Star")
              .beerStyle("PALE_ALE")
              .quantityToBrew(100)
              .upc(231109930L)
              .price(new BigDecimal("11.50"))
              .build());

      beerRepository.save(
          Beer.builder()
              .beerName("Galaxy Cat")
              .beerStyle("PALE_ALE")
              .quantityToBrew(100)
              .upc(34788900789L)
              .price(new BigDecimal("10.50"))
              .build());

      log.info("Saving a total of {} beers", beerRepository.count());
    }
  }
}
