package com.planet.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class PlanetPage {
    private WebDriver driver;
    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    public List getPlanets() {
        ArrayList<Planet> planets = new ArrayList<>();

        for (var planet: driver.findElements(By.className("planet"))) {
            planets.add(new Planet(planet));
        }
        return planets;
    }


}


