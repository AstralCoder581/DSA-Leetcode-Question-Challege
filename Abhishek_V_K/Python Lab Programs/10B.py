import pandas as pd
import matplotlib.pyplot as plt

# Load the Iris dataset
data = pd.read_csv("iris.csv")  # Assuming the dataset is named "iris.csv" in the same directory

# Display the first 5 rows
print("First 5 rows:\n", data.head())

# Display the last 5 rows
print("\nLast 5 rows:\n", data.tail())

# Display dataset information
print("\nDataset information:\n", data.info())

# Display value overview of each column (descriptive statistics)
print("\nValue overview of each column:\n", data.describe())

# Visualize the dataset using scatter plots (replace 'column1' and 'column2' with your desired columns)
plt.figure(figsize=(10, 6))
plt.scatter(data['column1'], data['column2'])
plt.xlabel('column1')
plt.ylabel('column2')
plt.title('Scatter Plot of {} vs. {}'.format('column1', 'column2'))
plt.show()

print("\nVisualizations generated successfully!")

