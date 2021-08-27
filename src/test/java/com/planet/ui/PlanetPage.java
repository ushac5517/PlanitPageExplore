package com.planet.ui;

import com.planet.strategies.Matchable;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPage {
    private WebDriver driver;
    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    private Planet getMatchingPlanet(Matchable matchingStrategy) throws Exception {
        for (var planetElement: driver.findElements(By.className("planet"))) {
            var planet = new Planet(planetElement);
            if(matchingStrategy.match(planet)) {
                return planet;
            }
        }
        throw new Exception("Couldn't match using" + matchingStrategy.getClass().toGenericString());
    }

    public List<Planet> getPlanets() {
        ArrayList<Planet> planets = new ArrayList<>();

        for (var planet: driver.findElements(By.className("planet"))) {
            planets.add(new Planet(planet));
        }
        return planets;
    }

    public Planet getPlanets(Predicate<Planet> matchingStrategy) {
        for (Planet planet : getPlanets()) {
            if( matchingStrategy.test(planet)){
                return planet;
            }
        }
        throw new NotFoundException();
    }


}


