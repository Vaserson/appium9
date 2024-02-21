package org.apidemos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class FirstTest {

    @Test
    public void firstTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos");
//                .noReset();

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        wait.until(visibilityOfElementLocated(AppiumBy.accessibilityId("Views"))).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()"
                        + ".scrollable(true).instance(0)).scrollTextIntoView(\"" + "TextSwitcher" + "\");")).click();

        wait.until(visibilityOfElementLocated(AppiumBy.accessibilityId("Next"))).click();

        String actualCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextSwitcher/android.widget.TextView"))).getText();

        Assert.assertEquals(actualCounter, "1");
    }
}