package com.planet.strategies;

import com.planet.ui.Planet;

import java.text.ParseException;
import java.util.function.Predicate;

public class MatchingFunctionExample {

    public static Predicate<Planet> getPlanetByName (String planetName) {
        return planet -> planet.getName().equals(planetName);
    }

    public static Predicate<Planet> getPlanetGT4000(Planet planetName) {
        return planet-> {
            try {
                return planet.getRadius() > 4000.0;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        };
    }
}
