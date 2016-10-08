package appium_01;

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
        capabilities.setCapability("appPackage", "com.danfoss.android_crosswalk_djinni_scc");
        capabilities.setCapability("appActivity", "com.danfoss.android_crosswalk_djinni_scc.MainActivity");
    
        dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        WebDriverWait wait = new WebDriverWait(dr, 30);
        
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//android.webkit.WebView[@index='0']")));
        
        WebElement txtbx = dr.findElementByXPath("//android.widget.EditText[@index='0']");
        //txtbx.Text = "Hej Polle!;"
        
            
    }
}