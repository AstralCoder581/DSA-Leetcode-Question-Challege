import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print("Original array:\n", arr)

# Reverse order (using slicing)
reversed_arr = arr[::-1, :]  # Reverse rows and keep columns the same
print("\nArray in reverse order:\n", reversed_arr)

# Principal diagonal elements
diagonal = arr.diagonal()
print("\nPrincipal diagonal elements:", diagonal)

# Sort the array (ascending and descending)
sorted_arr_asc = arr.copy()  # Copy to avoid modifying original array
sorted_arr_desc = arr.copy()

sorted_arr_asc.sort(axis=0)  # Sort along rows (ascending)
sorted_arr_desc.sort(axis=0, kind='mergesort')  # Sort along rows (descending) using mergesort for stability

print("\nArray sorted in ascending order:\n", sorted_arr_asc)
print("\nArray sorted in descending order:\n", sorted_arr_desc)

