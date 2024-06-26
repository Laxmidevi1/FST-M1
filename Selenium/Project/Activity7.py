from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs")
    driver.find_element(By.XPATH,"//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']").click()
    abc=driver.title
    print(" page title: " + abc)
    driver.find_element(By.XPATH,"//input[@id='create_account_email']").send_keys("12334@gmail.com")
    driver.find_element(By.XPATH,"//input[@id='job_title']").send_keys("ApplicationTester")
    driver.find_element(By.XPATH,"//input[@id='job_location']").send_keys("Pune")
