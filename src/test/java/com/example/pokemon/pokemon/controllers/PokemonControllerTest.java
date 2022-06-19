package com.example.pokemon.pokemon.controllers;

import com.example.pokemon.pokemon.models.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PokemonControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void getAllPokemon() {
        ResponseEntity<Pokemon[]> pokemonEntity = restTemplate.getForEntity("/pokemon/", Pokemon[].class);
        assertEquals(HttpStatus.OK, pokemonEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, pokemonEntity.getHeaders().getContentType());
        assertEquals(100, pokemonEntity.getBody().length);
    }

    @Test
    void getPokemon() {
        String name = "ditto";
        Pokemon pokemon = restTemplate.getForObject("/pokemon/"+name, Pokemon.class);
        assertEquals(name, pokemon.name());
        assertEquals(String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/%s.png", pokemon.id()), pokemon.image());
    }
}