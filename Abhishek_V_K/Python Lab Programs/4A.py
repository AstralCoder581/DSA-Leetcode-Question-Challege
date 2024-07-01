def initialize_users():
  return {'rahul': 'genius', 'kumar': 'smart', 'ankita': 'intelligent'}

def print_all(user_data):
  print("All items (username:password):")
  for user, password in user_data.items():
    print(user, ":", password)
    
def print_keys(user_data):
  print("\nAll usernames (keys):")
  for user in user_data.keys():
    print(user)
    
def print_values(user_data):   
  print("\nAll passwords (values):")
  for password in user_data.values():
    print(password)

def get_password(user_data, username):
  if username in user_data:
    return user_data[username]
  else:
    return None

def change_password(user_data, username, new_password):
  if username in user_data:
    user_data[username] = new_password
    print(username, "'s password changed successfully!")
  else:
    print(username, "not found in the dictionary.")

def main():
  user_data = initialize_users()
  while True:
    print("\nUser Management Menu:\n1. Print all items (username:password)\n2. Print all usernames (keys)\n3. Print all passwords (values)\n4. Get password of a user\n5. Change password of a user\n6. Exit")
    choice = input("Enter your choice (1-6): ")

    if choice == '1':
      print_all(user_data)
    elif choice == '2':
      print_keys(user_data)
    elif choice == '3':
      print_values(user_data) 
    elif choice == '4':
      username = input("Enter the username: ")
      password = get_password(user_data, username)
      if password:
        print(username, "'s password:", password)
      else:
        print(username, "not found in the dictionary.")
    elif choice == '5':
      username = input("Enter the username to change password: ")
      new_password = input("Enter the new password: ")
      change_password(user_data, username, new_password)
    elif choice == '6':
      print("Exiting the program.")
      break
    else:
      print("Invalid choice. Please try again.")

if __name__ == "__main__":
  main()

