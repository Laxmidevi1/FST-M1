package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.miui.calculator")
                .setAppActivity(".cal.CalculatorActivity")
                .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, caps);

    }

    @Test
    public void addTest(){
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("add")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();
        Assert.assertEquals(Integer.valueOf(result), 14);
    }

    @Test
    public void subtractTest(){
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("subtract")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();
        Assert.assertEquals(Integer.valueOf(result), 5);
    }

    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();
        Assert.assertEquals(Integer.valueOf(result), 500);
    }

    @Test
    public void divideTest(){
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();
        Assert.assertEquals(Integer.valueOf(result), 25);
    }
}
