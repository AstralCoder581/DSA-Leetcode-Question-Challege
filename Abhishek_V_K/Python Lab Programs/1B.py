words = ["apple", "banana", "cherry", "date"]
string_length_list = [(word, len(word)) for word in words]
sorted_list = sorted(string_length_list, key=lambda x: x[1])
print(sorted_list)
