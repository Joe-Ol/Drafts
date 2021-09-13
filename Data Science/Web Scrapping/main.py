import requests
import pandas
from bs4 import BeautifulSoup
from requests_html import HTMLSession

session = HTMLSession()
page = session.get("https://weather.com/en-IN/weather/tenday/l/e1d0bb735632de2df082e02f88493ef295908714761728c5c7d5d6c76cb2f83e")
soup = BeautifulSoup(page.content, "html.parser")

# create empty list
list = []
all = soup.find("div", {"class": "locations-title ten-day-page-title"}).find("h1").text

# find all table with class-"twc-table"
content = soup.find_all("table", {"class": "twc-table"})
for items in content:
    for i in range(len(items.find_all("tr")) - 1):
        # create empty dictionary
        dict = {}
        try:
            # assign value to given key

            dict["day"] = items.find_all("span", {"class": "date-time"})[i].text
            dict["date"] = items.find_all("span", {"class": "day-detail"})[i].text
            dict["desc"] = items.find_all("td", {"class": "description"})[i].text
            dict["temp"] = items.find_all("td", {"class": "temp"})[i].text
            dict["precip"] = items.find_all("td", {"class": "precip"})[i].text
            dict["wind"] = items.find_all("td", {"class": "wind"})[i].text
            dict["humidity"] = items.find_all("td", {"class": "humidity"})[i].text
        except:
            # assign None values if no items are there with specified class

            dict["day"] = "None"
            dict["date"] = "None"
            dict["desc"] = "None"
            dict["temp"] = "None"
            dict["precip"] = "None"
            dict["wind"] = "None"
            dict["humidity"] = "None"

        # append dictionary values to the list
        list.append(dict)

print(list)
