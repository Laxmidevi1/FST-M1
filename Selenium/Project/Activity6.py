from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs")
    driver.find_element(By.XPATH,"//a[@href='https://alchemy.hguy.co/jobs/jobs/']").click()
    abc=driver.title
    print("page title: " + abc)
    driver.find_element(By.ID,"search_keywords").send_keys("Banking")
    driver.find_element(By.XPATH,"//input[@value='Search Jobs']").click()
    driver.get("https://alchemy.hguy.co/jobs/job/ibm-2-banking/")
    driver.find_element(By.XPATH,"//input[@value='Apply for job']").click()
    driver.quit()
