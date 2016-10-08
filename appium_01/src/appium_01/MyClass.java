package appium_01;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class MyClass {

    AndroidDriver dr;
    @Test
    public void call() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Xperia Z Ultra");
        capabilities.setCapability("platforVersion", "5.1.1");
        capabilities.setCapability("platforName", "Android");
        //capabilities.setCapability("appPackage", "com.danfoss.android_crosswalk_djinni_scc");
        //capabilities.setCapability("appActivity", "com.danfoss.android_crosswalk_djinni_scc.MainActivity");
        //capabilities.setCapability("appPackage", "sauce_xamarin_test.sauce_xamarin_test");
        //capabilities.setCapability("appActivity", "sauce_xamarin_test.sauce_xamarin_test.MainActivity");
        File file = new File("C:\\test\\sauce_xamarin_test.sauce_xamarin_test.apk");
        capabilities.setCapability("app", file.getAbsolutePath());
    
        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebDriverWait wait = new WebDriverWait(dr, 30);
                
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//android.widget.EditText[@index='0']")));
        WebElement txtbx = dr.findElementByXPath("//android.widget.EditText[@index='0']");
        txtbx.sendKeys("Polle was here");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@index='0']")));
        WebElement btn = dr.findElementByXPath("//android.widget.Button[@index='0']");
        btn.click();
                
    }
}