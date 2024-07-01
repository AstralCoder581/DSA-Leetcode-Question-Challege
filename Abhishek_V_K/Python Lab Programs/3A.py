def add_word(word_dict):
  word = input("Enter the word: ")
  meaning = input("Enter its meaning: ")
  word_dict[word] = meaning
  print(word, "added successfully!")

def search_word(word_dict):
  word = input("Enter the word to search: ")
  if word in word_dict:
    print(word, "means:", word_dict[word])
  else:
    print(word, "not found in the dictionary.")

def find_by_meaning(word_dict):
  meaning = input("Enter the meaning to search for: ")
  matching_words = []
  for word, definition in word_dict.items():
    if definition == meaning:
      matching_words.append(word)
  if matching_words:
    print("Words with meaning", meaning, ":", ", ".join(matching_words))
  else:
    print("No words found with meaning", meaning)

def remove_word(word_dict):
  word = input("Enter the word to remove: ")
  if word in word_dict:
    del word_dict[word]
    print(word, "removed successfully!")
  else:
    print(word, "not found in the dictionary.")

def display_words(word_dict):
  sorted_words = sorted(word_dict.keys())
  print("Words in the dictionary:")
  for word in sorted_words:
    print(word)

def main():
  word_dict = {}
  while True:
    print("\nDictionary Menu:\n1. Add a new word\n2. Search for a word\n3. Find words with the same meaning\n4. Remove a word\n5. Display all words\n6. Exit")
    choice = input("Enter your choice (1-6): ")
    
    if choice == '1':
      add_word(word_dict)
    elif choice == '2':
      search_word(word_dict)
    elif choice == '3':
      find_by_meaning(word_dict)
    elif choice == '4':
      remove_word(word_dict)
    elif choice == '5':
      display_words(word_dict)
    elif choice == '6':
      print("Exiting the program.")
      break
    else:
      print("Invalid choice. Please try again.")

if __name__ == "__main__":
  main()

