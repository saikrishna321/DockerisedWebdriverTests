package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by saikrisv on 16/10/15.
 */
public class LoginPage {


    private final WebDriver driver;

    @FindBy(id = "user_email")
    public WebElement username_field;

    @FindBy(id = "user_password")
    public WebElement password_field;

    @FindBy(name = "commit")
    public WebElement click_login;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ClientHomePage loginPage(String username, String password) {
        username_field.sendKeys(username);
        password_field.sendKeys(password);
        click_login.click();
        return new ClientHomePage(driver);

    }

}
