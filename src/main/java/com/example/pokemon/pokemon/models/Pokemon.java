package com.example.pokemon.pokemon.models;

import java.util.ArrayList;

public record Pokemon(String name, String url, Integer id, String image, ArrayList<Stat> stats) {
}
