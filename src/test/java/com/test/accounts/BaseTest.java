package com.test.accounts;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import factory.ExtentManager;
import factory.ExtentTestManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by saikrisv on 16/10/15.
 */
public class BaseTest {
    public WebDriver driver;
    DesiredCapabilities capability;
    ExtentTest parent;
    ExtentTest child;
    private Map<Long, ExtentTest> parentContext = new HashMap<Long, ExtentTest>();

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
        parent = ExtentTestManager.startTest(getClass().getSimpleName(),"Sample Container Test",browser);
        parentContext.put(Thread.currentThread().getId(), parent);
    }

    @BeforeMethod
    public void startReport(Method methodName){
        child = ExtentTestManager
            .startTest(methodName.toString());
    }


    @AfterMethod
    public void endReport(ITestResult iTestResult){
        if(iTestResult.isSuccess()){
            ExtentTestManager.getTest()
                .log(LogStatus.PASS, iTestResult.getMethod().getMethodName(), "Pass");
        }else if(iTestResult.getStatus() ==  ITestResult.FAILURE){
            ExtentTestManager.getTest()
                .log(LogStatus.FAIL, iTestResult.getMethod().getMethodName(), "Fail");
        }
        parentContext.get(Thread.currentThread().getId()).appendChild(child);
        ExtentManager.getInstance().flush();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        ExtentManager.getInstance().endTest(parent);
        ExtentManager.getInstance().flush();
    }

    public void CaptureScreenShot(WebDriver driver, String screenShotName) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/target/"+screenShotName+".png"));
    }

}
