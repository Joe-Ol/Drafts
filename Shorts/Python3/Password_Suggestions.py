# Sample Browser Password Suggestor

import random

lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
numbers = str("0123456789")
symbols = str("!§$%&/()[]#+*';:,.-_^<>")

all = lower_case+upper_case+numbers+symbols

length = int(input("Enter Password Lenght: "))
password = "".join(random.sample(all,length))
print('Suggested Password is: ' + password)
