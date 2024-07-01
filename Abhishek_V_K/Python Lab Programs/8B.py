def write_to_file(filename, lines):
  with open(filename, 'w') as file:
    file.writelines(lines)

def count_characters(text):
  uppercase_count = 0
  lowercase_count = 0
  digit_count = 0

  for char in text:
    if char.isupper():
      uppercase_count += 1
    elif char.islower():
      lowercase_count += 1
    elif char.isdigit():
      digit_count += 1

  return uppercase_count, lowercase_count, digit_count

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

  with open(filename, 'r') as file:
    text = file.read()

  uppercase_count, lowercase_count, digit_count = count_characters(text)

  print("\nText content (sample):\n", text)
  print("\nCharacter counts:")
  print("Uppercase:", uppercase_count)
  print("Lowercase:", lowercase_count)
  print("Digits:", digit_count)

if __name__ == "__main__":
  main()

