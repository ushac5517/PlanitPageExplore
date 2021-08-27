package com.planet.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.NumberFormat;
import java.text.ParseException;

public class Planet {
    private float radius;
    private int distance;
    private String name;
    private WebElement planetElement;

    public Planet (WebElement planetElement) {
        this.planetElement = planetElement;
    }

    public float getRadius() throws ParseException {
        var radiusString = planetElement.findElement(By.className("radius")).getText();
        return NumberFormat.getNumberInstance().parse(radiusString.split(" ")[0]).floatValue();
    }

    public String getName() {
        return planetElement.findElement(By.className("name")).getText();
    }


    public void clickExplore() {
        planetElement.findElement(By.className("v-btn__content")).click();
    }
}
