package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by saikrisv on 16/10/15.
 */


public class ClientDetailsPage {


    private final WebDriver driver;

    public ClientDetailsPage(WebDriver driver) {
        this.driver=driver;
    }



    public ClientDetailsPage editClientsDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("headerAfter")));
        driver.findElement(By.className("headerAfter")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("client_company_name")));
        driver.findElement(By.id("client_company_name")).sendKeys("");
        driver.findElement(By.id("client_company_name")).sendKeys("DemoBootCamp" + "1");
        return new ClientDetailsPage(driver);

    }

    public String verifyClientDataIsEdited(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("client_contact_person_name")));
        String client_name = driver.findElement(By.id("client_contact_person_name")).getAttribute("value").toString();
        System.out.println(client_name);
        return client_name;
    }

}
