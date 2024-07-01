def find_max_min(arr):
  max_value = arr[0]
  min_value = arr[0]
  for num in arr:
    max_value = max(max_value, num)
    min_value = min(min_value, num)
  return max_value, min_value

def find_second_largest(arr):
  #if len(arr) < 2:
  #  return None
  largest = second_largest = arr[0]
  for num in arr[1:]:
    if num > largest:
      second_largest = largest
      largest = num
    elif num > second_largest and num != largest:
      second_largest = num
  return second_largest
  
arr = [5, 1, 4, 2, 8]

max_value, min_value = find_max_min(arr)
print("Maximum:", max_value)
print("Minimum:", min_value)

second_largest = find_second_largest(arr)
if second_largest is not None:
  print("Second largest:", second_largest)
else:
  print("Array has less than 2 elements.")
