def divide(numerator, denominator):
  try:
    result = numerator / denominator
  except ZeroDivisionError:
    print("Error: Cannot divide by zero.")
  except (TypeError, ValueError):
    print("Error: Invalid input types. Please enter numbers for both numerator and denominator.")
  else:
    print("Division successful.")
    return result
  finally:
    print("This is always executed, regardless of exceptions.")

try:
  divide(10, 2)  # Successful division
  divide(10, 0)  # ZeroDivisionError
  divide("hello", 2)  # ValueError (type mismatch)
  divide(10, None)  # ValueError (None type)
except Exception as e:  # Catch any unhandled exceptions
  print("Unexpected error:", e)

print("\nAll test cases completed.")

