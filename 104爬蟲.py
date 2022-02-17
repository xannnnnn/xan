# -*- coding: utf-8 -*-

import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common import keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions as EC

path="C:/Users/a8978/OneDrive/桌面/chromedriver.exe"
driver = webdriver.Chrome(path)
driver.get("https://www.104.com.tw/jobs/main/")

'''
actions = actions(driver)
actions.click()
'''
'''
login = driver.find_element_by_xpath('//*[@id="global_bk"]/ul/li[2]/ul/li[6]/a')
print(login.text)
login.click()

username = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "username"))
    )

password = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "password"))
    )
username.clear()
password.clear()
username.send_keys('root')
password.send_keys('123456')

login_check = driver.find_element_by_xpath('//*[@id="submitBtn"]/h2')
login_check.click()
'''

ikeyword = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "ikeyword"))
   )     
ikeyword.send_keys('後端工程師')
time.sleep(5)
city=driver.find_element_by_id("icity")
city.click()
time.sleep(5)
city_taipei = driver.find_element_by_xpath('/html/body/div[12]/div/div[2]/div/div[2]/div[2]/div/li[1]/a/span[1]/input')
city_taipei.click()

NewTaipei=driver.find_element_by_xpath("/html/body/div[12]/div/div[2]/div/div[2]/div[2]/div/li[2]/button")
NewTaipei.click()
#板橋
NewTaipei_Banqiao = driver.find_element_by_xpath('/html/body/div[12]/div/div[2]/div/div[2]/div[2]/div/ul[2]/div/li[3]/a/span[1]/input')
NewTaipei_Banqiao.click()
#永和
NewTaipei_Yonghe = driver.find_element_by_xpath('/html/body/div[12]/div/div[2]/div/div[2]/div[2]/div/ul[2]/div/li[14]/a/span[1]/input')
NewTaipei_Yonghe.click()
#中和
NewTaipei_neutralize = driver.find_element_by_xpath('/html/body/div[12]/div/div[2]/div/div[2]/div[2]/div/ul[2]/div/li[15]/a/span[1]/input')
NewTaipei_neutralize.click()
#土城
NewTaipei_Tucheng = driver.find_element_by_xpath('/html/body/div[12]/div/div[2]/div/div[2]/div[2]/div/ul[2]/div/li[16]/a/span[1]/input')
NewTaipei_Tucheng.click()

city_check = driver.find_element_by_xpath("/html/body/div[12]/div/div[2]/div/div[3]/button")
city_check.click()
time.sleep(2)

search = driver.find_element_by_xpath("/html/body/article[1]/div/div/div[4]/div/button")
search.click()

time.sleep(5)
'''
//*[@id="js-job-content"]/article[2]/div[1]/h2/a
//*[@id="js-job-content"]/article[1]/div[1]/h2/a


titles=driver.find_elements_by_class_name('js-job-link')
for title in titles:
    driver1=title.get_attribute("href")
    print(driver1)
    driver = webdriver.Chrome(path)
    driver.get(driver1)
    time.sleep(2)
    driver.quit()
'''

btn=driver.find_element_by_class_name('js-next-page')
print(btn.text)
btn.click()



btn = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located(By.CLASS_NAME('js-next-page'))
                                       )
btn.click()

'''
print(titles.get_attribute("scr"))
link = driver.find_element_by_link_text(titles.text)
print(titles.get_attribute("scr"))
link.click()
for title in titles:
 print(title.text)
 link = driver.find_element_by_link_text(title.text)
 link.click()


time.sleep(5)
driver.quit()
'''