import random

def is_odd_length_2_or_4(number):
  number_str = str(number)  # Convert to string for length check
  return number % 2 != 0 and len(number_str) in (2, 4)
  
numbers = [random.randint(1, 100) for _ in range(20)]
odd_numbers_length_2_4 = [num for num in numbers if is_odd_length_2_or_4(num)]

if odd_numbers_length_2_4:
  print("Odd numbers of length 2 or 4:", odd_numbers_length_2_4)
else:
  print("No odd numbers of length 2 or 4 found in the list.")

