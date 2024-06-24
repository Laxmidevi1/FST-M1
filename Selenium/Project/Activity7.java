package SelJava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7
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
        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();

        driver.findElement(By.xpath("//input[@id='create_account_email']")).sendKeys("tsaiprasad18@gmail.com");
        driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys("Manual QA");
        driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys("Hyderabad");
        //driver.findElement(By.xpath("//input[@id='job_type']")).sendKeys("Hybrid");
        driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")).sendKeys("  Hi.......Bye");
        driver.findElement(By.xpath("//input[@id='application']")).sendKeys("tsaiprasad18@gmail.com");
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("IBM INDIA PVT. LTD.");
        driver.findElement(By.xpath("//input[@id='company_website']")).sendKeys("http://ibm.com");
        driver.findElement(By.xpath("//input[@id='company_tagline']")).sendKeys("IBM WatsonX Welcomes You");
        driver.findElement(By.xpath("//input[@id='company_video']")).sendKeys("video.mp4");
        driver.findElement(By.xpath("//input[@id='company_twitter']")).sendKeys("tsaiprasad18");

        driver.findElement(By.xpath("//input[@value='Preview']")).click();

        driver.findElement(By.xpath("//input[@value='Submit Listing']")).click();

        driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/jobs/']")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("Manual QA");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

    }

    @AfterClass
    public void afterMethod()
    {
        driver.quit();
    }
}