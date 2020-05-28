package com.mytests;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NotepadTest {
    public static WindowsDriver driver=null;
    @BeforeMethod
    public void setup(){
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("app","C:\\Windows\\System32\\notepad.exe");
        cap.setCapability("platformName","Windows");
        cap.setCapability("deviceName","WindowsPC");
        try {


        driver=new WindowsDriver(new URL("http://127.0.0.1:4723"),cap);
    }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();

    }
    @Test
    public void checkHelpAboutNowTest(){
        driver.findElementByName("Help").click();
        driver.findElementByName("About Notepad").click();
        driver.findElementByName("OK").click();

    }
    @Test
    public void sendText(){
        driver.findElementByName("Text Editor").sendKeys("This is Notepad Text help of automation");
        driver.findElementByName("Text Editor").clear();
    }
    @Test(priority = 3)
    public void enterTimeanddate(){
        driver.findElementByName("Edit").click();
    driver.findElementByAccessibilityId("26").click();
    String value=driver.findElementByName("Text Editor").getAttribute("Value.Value");
        System.out.println(value);
        Assert.assertTrue(value.contains("28-05-2020"));}
}
