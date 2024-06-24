package SelJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {
    WebDriver driver;

    @BeforeClass
    public void beforeMethod()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    public void exampleTest()
    {
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();

        driver.findElement(By.xpath("//a[@href='edit.php?post_type=job_listing']")).click();
        driver.findElement(By.linkText("Add New")).click();
        driver.findElement(By.xpath("//textarea[@class='editor-post-title__input']")).sendKeys("Application Tester1");
        driver.findElement(By.xpath("//button[text()='Publish...']")).click();
    }

    @AfterClass
    public void afterMethod()
    {
        driver.quit();
    }

}
