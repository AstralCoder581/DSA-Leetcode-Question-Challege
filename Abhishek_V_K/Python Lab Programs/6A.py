def binarySearch(arr, key):
  low = 0
  high = len(arr) - 1
  mid = 0

  while low <= high:
    mid = (high + low) // 2
    if arr[mid] == key:
      return mid
    elif arr[mid] < key:
      low = mid + 1
    else:
      high = mid - 1
  return -1
arr = [2, 3, 4, 10, 40]
key = 10
result = binarySearch(arr, key1)
if result != -1:
  print("Element", key, "is present at index", str(result))
else:
  print("Element", key, "is not present in array")

