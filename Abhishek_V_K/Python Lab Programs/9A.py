import pandas as pd
import matplotlib.pyplot as plt
data = pd.read_csv('your_dataset.csv')
scatter_column = 'column_name'
plt.figure(figsize=(10, 6))  # Adjust figure size as needed

# Generate random colors for each data point
colors = plt.cm.get_cmap('tab20')(np.linspace(0, 1, len(data)))

# Create the scatter plot with custom colors
plt.scatter(data['index_column'], data[scatter_column], c=colors)  # Replace 'index_column' with your index if needed
plt.xlabel('Index')  # Replace 'Index' with actual column name if using a custom index
plt.ylabel(scatter_column)
plt.title('Scatter Plot of {}'.format(scatter_column))
plt.show()
# Choose a column for histogram (replace 'column_name' with your desired column)
histogram_column = 'column_name'

# Histogram
plt.figure(figsize=(8, 5))
plt.hist(data[histogram_column], bins=10, edgecolor='black')  # Adjust bin count as needed
plt.xlabel(histogram_column)
plt.ylabel('Frequency')
plt.title('Histogram of {}'.format(histogram_column))
plt.show()

print("Visualizations generated successfully!")

