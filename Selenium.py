import requests, time
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as ec

url = 'https://codeforces.com'
# Put your codeforces handle here
username = input("Enter your username:")
# Put your password here
password = input("Enter your password:")
# Put the group ID here
# E.g: 'abc' in case of https://codeforces.com/group/abc
groupID = input("Now, you have to put the desired codeforces group\nE.g: 'abc' in case of https://codeforces.com/group/abc\nEnter the groupID:")

URL = url + "/group/" + groupID + "/members"
r = requests.get(URL)

soup = BeautifulSoup(r.content, 'html5lib')
soup = soup.findAll('table')[1]
soup = soup.findAll('tr')

driver = webdriver.Chrome()

driver.get(url + "/enter")
driver.release()

element = WebDriverWait(driver, 10).until(ec.visibility_of_element_located((By.ID, "handleOrEmail")))
element.send_keys(username)

element = WebDriverWait(driver, 10).until(ec.visibility_of_element_located((By.ID, "password")))
element.send_keys(password)

element = WebDriverWait(driver, 10).until(ec.visibility_of_element_located((By.CSS_SELECTOR, ".submit")))
element.click()

element = WebDriverWait(driver, 10).until(ec.visibility_of_element_located((By.CSS_SELECTOR, ".header-bell__img")))

for i in range(1,len(soup)):
	name =  soup[i].findAll("a", {"class": "rated-user"})[0]
	if name['href'].lower() == '/profile/' + username.lower():
		continue
	driver.get(url + name['href'])
	element = WebDriverWait(driver, 10).until(ec.visibility_of_element_located((By.CSS_SELECTOR, ".friendStar")))
	try:
		element = driver.find_element_by_css_selector('.addFriend').click()
		element = WebDriverWait(driver, 10).until(ec.visibility_of_element_located((By.CSS_SELECTOR, ".removeFriend")))
	except:
		continue

element = driver.find_element_by_css_selector('.lang-chooser > div:nth-child(2) > a:nth-child(2)').click()
element = WebDriverWait(driver, 6).until(ec.visibility_of_element_located((By.ID, "handleOrEmail")))

driver.quit()
driver.release()