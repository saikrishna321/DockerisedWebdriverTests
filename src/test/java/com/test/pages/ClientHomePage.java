package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by saikrisv on 16/10/15.
 */
public class ClientHomePage {


    private final WebDriver driver;

    public ClientHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public ClientDetailsPage searchClients(String arg){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CLIENTS")));
        driver.findElement(By.linkText("CLIENTS")).click();
        driver.findElement(By.id("search")).sendKeys(arg);
        driver.findElement(By.cssSelector(".searchBtn")).click();
        driver.findElement(By.xpath("//table//tbody//tr[1]/td/a")).click();
        return new ClientDetailsPage(driver);
    }


}
