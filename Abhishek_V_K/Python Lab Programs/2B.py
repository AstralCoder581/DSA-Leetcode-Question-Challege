subjects = ["Data Structures", "Algorithms", "Database Management Systems",
             "Computer Networks", "Operating Systems", "Python Programming Lab"]

# Display the list using for loop
print("List of subjects:")
for subject in subjects:
  print(subject)

# Display 2nd and 5th element of the list
print("\n2nd element:", subjects[1])
print("5th element:", subjects[4])

# Display first 4 elements of the list using range of indexes
print("\nFirst 4 elements:", subjects[:4])

# Display last 4 elements of the list using negative indexes
print("\nLast 4 elements:", subjects[-4:])

# Check if "Python Programming Lab" is in the list
if "Python Programming Lab" in subjects:
  print("\nPython Programming Lab is available in the list.")
else:
  print("\nPython Programming Lab is not available in the list.")

# Demonstrate append() function (adding element at the end)
subjects.append("Software Engineering")
print("\nList after appending 'Software Engineering':", subjects)

# Demonstrate insert() function (adding element at a specific position)
subjects.insert(2, "Discrete Mathematics")
print("\nList after inserting 'Discrete Mathematics' at index 2:", subjects)

# Demonstrate remove() function (removing by value)
subjects.remove("Database Management Systems")
print("\nList after removing 'Database Management Systems':", subjects)

# Demonstrate pop() function (removing and returning the last element)
last_subject = subjects.pop()
print("\nList after removing the last element (", last_subject, "):", subjects)

