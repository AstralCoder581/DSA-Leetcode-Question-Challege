class Stack:
  def __init__(self):
    self.items = []

  def is_empty(self):
    return len(self.items) == 0

  def push(self, item):
    self.items.append(item)

  def pop(self):
    if self.is_empty():
      raise IndexError("Pop from empty stack")
    return self.items.pop()

  def peek(self):
    if self.is_empty():
      raise IndexError("Peek from empty stack")
    return self.items[-1]

class Queue:
  def __init__(self):
    self.items = []

  def is_empty(self):
    return len(self.items) == 0

  def enqueue(self, item):
    self.items.append(item)

  def dequeue(self):
    if self.is_empty():
      raise IndexError("Dequeue from empty queue")
    return self.items.pop(0)

  def peek(self):
    if self.is_empty():
      raise IndexError("Peek from empty queue")
    return self.items[0]

stack = Stack()

# Test push and peek
stack.push(1)
stack.push(2)
print("Peek:", stack.peek())  # Output: 2

# Test pop (empty check)
try:
  stack.pop()
  stack.pop()
  stack.pop()  # Should raise IndexError
except IndexError as e:
  print("Stack pop error:", e)

stack.push(3)
stack.push(4)

# Test pop and peek again
print("Popped:", stack.pop())  # Output: 4
print("Peek:", stack.peek())  # Output: 3

# Test cases for Queue
queue = Queue()

# Test enqueue and peek
queue.enqueue(10)
queue.enqueue(20)
print("Peek:", queue.peek())  # Output: 10

# Test dequeue (empty check)
try:
  queue.dequeue()
  queue.dequeue()
  queue.dequeue()  # Should raise IndexError
except IndexError as e:
  print("Queue dequeue error:", e)

queue.enqueue(30)
queue.enqueue(40)

# Test dequeue and peek again
print("Dequeued:", queue.dequeue())  # Output: 10
print("Peek:", queue.peek())  # Output: 20

print("\nAll tests completed successfully!")

