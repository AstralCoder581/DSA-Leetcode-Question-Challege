class InsufficientFundsError(Exception):
  pass

class InvalidTransactionError(Exception):
  pass

class SavingAccount:
  def __init__(self, initial_deposit):
    if initial_deposit <= 0:
      raise InvalidTransactionError("Initial deposit must be positive.")
    self.balance = initial_deposit

  def deposit(self, amount):
    if amount <= 0:
      raise InvalidTransactionError("Deposit amount must be positive.")
    self.balance += amount
    print("Deposited", amount, ". New balance:", self.balance)

  def withdraw(self, amount):
    if amount <= 0:
      raise InvalidTransactionError("Withdrawal amount must be positive.")
    if amount > self.balance:
      raise InsufficientFundsError("Insufficient funds for withdrawal.")
    self.balance -= amount
    print("Withdrew", amount, ". New balance:", self.balance)

  def get_balance(self):
    return self.balance

account = SavingAccount(100)
try:
  account.deposit(50)  # Successful deposit
  account.withdraw(75)  # Successful withdrawal
  account.withdraw(150)  # Raises InsufficientFundsError
  account.deposit(-20)  # Raises InvalidTransactionError
except InvalidTransactionError as e:
  print("Error:", e)
except InsufficientFundsError as e:
  print(e)

print("Final balance:", account.get_balance())

