def perform_operation(num1, num2, choice):
  if choice == 1:
    return num1 + num2
  elif choice == 2:
    return num1 - num2
  elif choice == 3:
    return num1 * num2
  elif choice == 4:
    if num2 == 0:
      return "Error: Cannot divide by zero"
    else:
      return num1 / num2
  else:
    return "Invalid choice"

def main():
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))
    print("Choose operation (1-Add, 2-Subtract, 3-Multiply, 4-Divide): ")
    choice = int(input())
    result = perform_operation(num1, num2, choice)
    print(result)

if __name__ == "__main__":
  main()
