package com.example.pokemon.pokemon.services;

import com.example.pokemon.pokemon.models.Pokemon;
import com.example.pokemon.pokemon.models.PokemonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PokemonService {

    @Autowired
    private Environment env;
    @Value("${spring.datasource.username:https://pokeapi.co/api/v2}")
    private String pokemonApiBaseUrl;
    private final WebClient webClient;

    public PokemonService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://pokeapi.co/api/v2").build();
    }

    public Pokemon getPokemon(String name) {
        return this.webClient.get().uri("/pokemon/{name}", name)
                .retrieve().bodyToMono(Pokemon.class).block();
    }

    public PokemonList getAllPokemon() {
        return this.webClient.get().uri("/pokemon/?limit=100&offset=0")
                .retrieve().bodyToMono(PokemonList.class).block();
    }
}
