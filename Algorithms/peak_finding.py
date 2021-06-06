
x = [12,34,90,33,35,99]

end = len(x) - 1
"""


if len(x) % 2 == 0:
    m = int((0 + end) / 2)
else:
    m = int((0 + end + 1) / 2)
    
print(m)
"""


def find(arr, start, stop):
    # global peak

    if stop % 2 == 0:
        mid = int((start + stop) / 2)
    else:
        mid = int((start + stop - 1) / 2)

    if arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1]:
        peak = arr[mid]
        return peak

    elif arr[mid] < arr[mid - 1]:
        peak = find(arr, start, mid-1)
        return peak

    else:
        peak = find(arr, mid + 1, stop)
        return peak


print(find(x, 0, end))
