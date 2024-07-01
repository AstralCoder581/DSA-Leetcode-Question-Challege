my_tuple = ("apple", "banana", "cherry")
print("Length of the tuple:", len(my_tuple))
item_to_check = "banana"
if item_to_check in my_tuple:
  print(item_to_check, "is present in the tuple.")
else:
  print(item_to_check, "is not present in the tuple.")
print("Second element:", my_tuple[1])
new_fruit = "orange"
new_tuple = my_tuple + (new_fruit,)
print("\nNew tuple with added item:", new_tuple)

