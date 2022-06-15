package com.example.pokemon.pokemon.models;

import java.util.ArrayList;

public record Pokemon(String name, String url, Integer id, String image, ArrayList<Stat> stats) {

    public String image() {
        if (this.url == null) {
            return String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/%s.png", this.id.toString());
        }

        String id = this.url.split("/")[6];
        return String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%s.png", id);
    }
}
