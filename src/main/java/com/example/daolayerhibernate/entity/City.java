package com.example.daolayerhibernate.entity;

import java.util.List;
import java.util.Random;

public enum City {
    MOSCOW,
    TOMSK,
    NOVOSIBIRSK,
    IRKUTSK;

    public static City getRandomCity(Random random) {
        return List.of(City.values()).get(random.nextInt(City.values().length));
    }
}
