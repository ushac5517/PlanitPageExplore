package com.planet.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlanetButton() {
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
    }
}
