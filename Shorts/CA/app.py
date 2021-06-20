# Install libraries from requirements.txt before running this script

import pandas as pd
import tabula
import easygui
import re
import os

ams_class_list_path = easygui.fileopenbox(msg="Select Class List Downloaded from AMS")
export_path = str(ams_class_list_path) + '.csv'
zoom_session_list_path = easygui.fileopenbox(msg="Select Session List Downloaded from Zoom Records")

tabula.convert_into(ams_class_list_path, export_path, output_format="csv", pages="all")

class_list = pd.read_csv(export_path)
class_list_numbers = class_list['Student Number'].values.tolist()

while True:
    try:
        class_list_numbers.remove("Student Number")
    except:
        break

attendance_list = pd.read_csv(zoom_session_list_path)


def extract_number(x):
    y = re.findall(r'\d+', x)
    if len(y) == 0:
        z = ''
    else:
        z = int(y[0])
    return z


attendance_list['Numbers'] = attendance_list['Name (Original Name)'].apply(lambda x: extract_number(x))
att_list_numbers = attendance_list['Numbers'].values.tolist()

while '' in att_list_numbers:
    att_list_numbers.remove('')

absent_list = []
for item in class_list_numbers:
    if item not in att_list_numbers:
        absent_list.append(item)

easygui.msgbox(msg='Absent Students' + str(absent_list), title='Absent Students', ok_button='Exit', root=None)

if os.path.exists(export_path):
    os.remove(export_path)
else:
    print("The file does not exist")
