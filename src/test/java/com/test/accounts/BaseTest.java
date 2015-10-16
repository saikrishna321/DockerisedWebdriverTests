package com.test.accounts;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by saikrisv on 16/10/15.
 */
public class BaseTest {
    public WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://accountsdemo.herokuapp.com/users/sign_in");
        //loginPage.loginPage("hackerdemo@gmail.com","Hello123",driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
