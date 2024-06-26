# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    expected = "Alchemy Jobs – Job Board Application"
    driver.get("https://alchemy.hguy.co/jobs")
    abc = driver.title
    print("Home page title: " + abc)
    if expected == abc:
        print(" get tittle and home page titles are same")
        driver.quit()
    else:
        print(" get tittle and home page titles are not same")
