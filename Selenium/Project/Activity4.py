from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    expected="Quia quis non"
    driver.get("https://alchemy.hguy.co/jobs")
    abc=driver.find_element(By.TAG_NAME,"h2").text
    print("second heading of webpage :" + abc)
    if expected == abc:
        print("webpage 2nd heading and expected  heading  are same")
        driver.quit()
    else:
        print("webpage 2nd heading and expected  heading  are not same")
