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

public class Activity6
{
    WebDriver driver;

    @BeforeClass
    public void beforeMethod()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void exampleTestCase()
    {

        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

        List<WebElement> jobListings = driver.findElements(By.xpath("//ul[@class='job_listings']/li"));
        if (!jobListings.isEmpty())
        {
            WebElement firstJobListing = jobListings.get(0);
            firstJobListing.findElement(By.tagName("a")).click();

            // Click the apply button and print the email to the console
            WebElement applyButton = driver.findElement(By.className("application_button"));
            applyButton.click();
            String email = driver.findElement(By.className("job_application_email")).getText();
            System.out.println("Job Application Email: " + email);
        } else
        {
            System.out.println("No job listings found for the given search criteria.");
        }

    }

    @AfterClass
    public void afterMethod()
    {
        driver.quit();
    }


}
