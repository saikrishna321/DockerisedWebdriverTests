package com.test.accounts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by saikrisv on 16/10/15.
 */
public class BaseTest {
    public WebDriver driver;
    DesiredCapabilities capability;

    @BeforeClass
    @Parameters({"browserType"})
    public void setUp(String browser) throws MalformedURLException {
        if(browser.equals("firefox")){
            capability = DesiredCapabilities.firefox();
        }else{
            capability = DesiredCapabilities.chrome();
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.get("http://accountsdemo.herokuapp.com/users/sign_in");
        //loginPage.loginPage("hackerdemo@gmail.com","Hello123",driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void CaptureScreenShot(WebDriver driver, String screenShotName) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/target/"+screenShotName+".png"));
    }

}
