package com.azubike.msscbeerservice.web.controllers;

import com.azubike.msscbeerservice.services.BeerService;
import com.azubike.msscbeerservice.util.TestUtils;
import com.azubike.msscbeerservice.web.model.BeerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerServiceController.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
class BeerServiceControllerTest {

  @Autowired private MockMvc mockMvc;
  @Autowired ObjectMapper objectMapper;
  @MockBean BeerService beerService;

  @Test
  void getBeerById() throws Exception {
    when(beerService.getBeerById(any(UUID.class))).thenReturn(TestUtils.createValidBeerDto());
    mockMvc
        .perform(
            get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void saveNewBeer() throws Exception {
    BeerDto beerDto = TestUtils.createBeerDto();
    String beerDtoJSON = objectMapper.writeValueAsString(beerDto);
    when(beerService.saveNewBeer(any(BeerDto.class))).thenReturn(TestUtils.createValidBeerDto());
    mockMvc
        .perform(
            post("/api/v1/beer")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJSON))
        .andExpect(status().isCreated());
  }

  @Test
  void updateBeerById() throws Exception {
    BeerDto beerDto = TestUtils.createBeerDto();
    String beerDtoJSON = objectMapper.writeValueAsString(beerDto);
    mockMvc
        .perform(
            put("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJSON))
        .andExpect(status().isOk());
  }
}
