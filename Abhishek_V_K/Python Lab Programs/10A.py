def handle_exceptions():
  # NameError
  try:
    print(undefined_variable)  # This variable is not defined, causing NameError
  except NameError:
    print("NameError: Variable 'undefined_variable' is not defined.")
  # IndexError
  try:
    my_list = [1, 2, 3]
    print(my_list[5])  # Accessing an out-of-bounds index
  except IndexError:
    print("IndexError: List index out of range.")
  # KeyError
  try:
    my_dict = {"name": "Alice"}
    print(my_dict["age"])  # Accessing a non-existent key
  except KeyError:
    print("KeyError: Key 'age' not found in the dictionary.")
  # ZeroDivisionError
  try:
    result = 10 / 0
  except ZeroDivisionError:
    print("ZeroDivisionError: Cannot divide by zero.")

# Call the function to demonstrate exception handling
handle_exceptions()

print("\nAll exceptions handled successfully!")

