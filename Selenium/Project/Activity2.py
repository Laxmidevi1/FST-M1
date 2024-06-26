from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:

    expected = "Welcome to Alchemy Jobs"
    driver.get("https://alchemy.hguy.co/jobs")
    abc=driver.find_element(By.CLASS_NAME,"entry-title").text
    print("Home page title: " + abc)
    if expected == abc:
        print(" webpage heading and expected  heading  are same")
        driver.quit()
    else:
        print("webpage heading and expected  heading  are not saame")
