def write_to_file(filename, lines):
  with open(filename, 'w') as file:
    file.writelines(lines)

def find_longest_shortest(filename):
  longest_word = ""
  shortest_word = ""
  max_length = 0
  min_length = float('inf')  # Set initial min to positive infinity

  with open(filename, 'r') as file:
    for line in file:
      words = line.strip().split()  # Remove extra spaces and split into words
      for word in words:
        word_length = len(word)
        if word_length > max_length:
          longest_word = word
          max_length = word_length
        if word_length < min_length and word_length > 0:  # Ignore empty strings
          shortest_word = word
          min_length = word_length

  return longest_word, max_length, shortest_word, min_length

def main():
  filename = "user_text.txt"
  lines = []

  while True:
    num_lines = int(input("Enter the number of lines (5-6): "))
    if 5 <= num_lines <= 6:
      for i in range(num_lines):
        line = input("Enter line {}: ".format(i+1))
        lines.append(line + "\n")  # Add newline for proper formatting
      break
    else:
      print("Invalid number of lines. Please enter between 5 and 6.")

  write_to_file(filename, lines)

  longest_word, longest_length, shortest_word, shortest_length = find_longest_shortest(filename)

  print("\nLongest word:", longest_word, "(", longest_length, "characters)")
  print("Shortest word:", shortest_word, "(", shortest_length, "characters)")

if __name__ == "__main__":
  main()

