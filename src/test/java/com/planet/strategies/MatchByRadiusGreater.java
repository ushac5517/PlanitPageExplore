package com.planet.strategies;

import com.planet.ui.Planet;

import java.text.ParseException;

public class MatchByRadiusGreater implements Matchable {
    private float targetRadius;

    public MatchByRadiusGreater(float targetRadius) {
        this.targetRadius = targetRadius;
    }

    @Override
    public boolean match(Planet planet) throws ParseException {
        return planet.getRadius() > 4000.0;
    }
}