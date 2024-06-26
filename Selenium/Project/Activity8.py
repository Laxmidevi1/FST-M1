from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.core import driver
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("https://alchemy.hguy.co/jobs/wp-admin")
    driver.find_element(By.XPATH,"//input[@id='user_login']").send_keys("root")
    driver.find_element(By.XPATH,"//input[@id='user_pass']").send_keys("pa$$w0rd")
    driver.find_element(By.XPATH,"//input[@id='wp-submit']").click()
    driver.quit()
