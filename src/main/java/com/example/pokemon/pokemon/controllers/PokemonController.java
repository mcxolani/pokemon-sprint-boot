package com.example.pokemon.pokemon.controllers;

import com.example.pokemon.pokemon.models.Pokemon;
import com.example.pokemon.pokemon.models.PokemonList;
import com.example.pokemon.pokemon.services.PokemonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin()
public class PokemonController {

    @Value("${spring.datasource.username:https://pokeapi.co/api/v2}")
    private String pokemonApiBaseUrl;

    PokemonService pokemonService;

    PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public ArrayList<Pokemon> getAllPokemon() {
        PokemonList pokemonResults = this.pokemonService.getAllPokemon();
        return pokemonResults.results();
    }

    @GetMapping("/{name}")
    public Pokemon getPokemon(@PathVariable("name") String name) {
        return pokemonService.getPokemon(name);
    }

}
