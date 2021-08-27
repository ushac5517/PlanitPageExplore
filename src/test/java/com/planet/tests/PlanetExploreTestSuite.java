package com.planet.tests;

import com.planet.strategies.MatchByRadiusGreater;
import com.planet.ui.HomePage;
import com.planet.ui.Planet;
import com.planet.ui.PlanetPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.util.ArrayList;

public class PlanetExploreTestSuite {
    WebDriver driver;

    @BeforeEach
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d21vtxezke9qd9.cloudfront.net/");
    }

    @Test
    private boolean isPlanetRadiusGreater(Planet currentFurthest, Planet planet) throws ParseException {
        return new MatchByRadiusGreater(getRadiusWithNullHandling(currentFurthest)).match(planet);
    }

    private float getRadiusWithNullHandling(Planet currentPlanet) throws ParseException {
        return (currentPlanet == null) ? 0 : currentPlanet.getRadius();
    }
    @Test
    public void PlanetsPage_ExploreButton_Test() throws ParseException {

        //Arrange
        new HomePage(driver).clickPlanetButton();
        var planetPage = new PlanetPage(driver);

        //Act
        Planet currentPlanet = null;
        for (var planet : planetPage.getPlanets()) {
            if (isPlanetRadiusGreater(currentPlanet , (Planet) planet)) {
                currentPlanet = (Planet) planet;
                currentPlanet.clickExplore();

                //Assert
                Assertions.assertEquals("Exploring " + currentPlanet.getName(), driver.findElement(By.cssSelector("[class*='popup-message']")).getText());
            }
        }
    }

    @AfterEach
    public void CleanUp() {
       driver.quit();
    }
}
