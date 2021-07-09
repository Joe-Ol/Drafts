import scrap
import requests

client_access_token = scrap.API_TOKEN

search_term = "Missy Elliott"

genius_search_url = f"http://api.genius.com/search?q={search_term}&access_token={client_access_token}"

# print(genius_search_url)


response = requests.get(genius_search_url)
json_data = response.json()
# print(json_data['response']['hits'][0])

for song in json_data['response']['hits']:
    print(song['result']['full_title'])

for song in json_data['response']['hits']:
    print(song['result']['full_title'], song['result']['stats']['pageviews'])