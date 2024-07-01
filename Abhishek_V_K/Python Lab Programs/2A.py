def is_prime(num):
  if num <= 1:
    return False
  for i in range(2, int(num**0.5) + 1):
    if num % i == 0:
      return False
  return True

def main():
  while True:
      start = int(input("Enter the lower limit of the range: "))
      end = int(input("Enter the upper limit of the range: "))
      if start >= end:
        print("Invalid range. Lower limit should be less than upper limit.")
      else:
        break
  print("Prime numbers between", start, "and", end, "are:")
  for num in range(start, end + 1):
    if is_prime(num):
      print(num)

if __name__ == "__main__":
  main()

