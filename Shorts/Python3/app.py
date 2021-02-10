"""
1. Download the student class list from ams and name it CL or any other name just keep it in mind.
2. Convert downloaded class list into CSV
3. Import CSV classlist file
4. Import Zoom Meeting report file
"""



import pandas as pd
import tabula
import re

# convert PDF into CSV file
tabula.convert_into("CL.pdf", "CL.csv", output_format="csv", pages='all')   # import class list and convert into a csv

class_list = pd.read_csv("CL.csv")      # import converted csv class list file into a dataframe
class_list_numbers = class_list['Student Number'].values.tolist()   # capture student numbers from class list dataframe.
while True:
    try:
        class_list_numbers.remove("Student Number")
    except:
        break

att_list = pd.read_csv("AT.csv")    # Import zoom meeting report file i.e. attedance list


def extract_number(x):
    y = re.findall(r'\d+', x)
    if len(y) == 0:
        z = ''
    else:
        z = int(y[0])
    return z


att_list['Numbers'] = att_list['Name (Original Name)'].apply(lambda x: extract_number(x))
att_list_numbers = att_list['Numbers'].values.tolist()

while '' in att_list_numbers:
    att_list_numbers.remove('')

absent_list = []
for item in class_list_numbers:
    if item not in att_list_numbers:
        absent_list.append(item)

print(absent_list)
