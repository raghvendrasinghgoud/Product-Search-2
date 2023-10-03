Problem Statement

Implement a standalone product search program in Java, using Hibernate that lists matching products for a user who is looking for T-shirts.
You are given 3 CSV files, each containing the T-shirts data for Nike, Puma and Adidas respectively. Use the same CSV files as provided in Assignment 1. You can add more data in existing files or can add more CSV files for another companies. The data from these files needs to be persisted in the database. All the search operations for the flights will be done on the database using hibernate.

Input
Program should accept 4 input parameters
Colour
Size
Gender
Output Preference 

“Gender” is a String which has two possible values like ‘M’ and ‘F’. M=Male and F=Female.
“Output Preference” is a String which suggests whether the results should be sorted only by Price or by Rating or by both  Price and Rating


Expected Behavior and Output

After getting the inputs, program should search for the T-shirts in the database and list the results on standard output, sorted as per Output Preference.
Program should be written considering that there could be more csv files and at runtime program should load the files. Please make use of Thread which will look for any new file at particular location after some configurable time and load the provided file
If no matching flight is found for the given input, user friendly output should be displayed on the screen.
Maven 3.x should be used
Use the new features of Java 8 wherever possible
Output
Program should display the list of available T-shirts with details on console  for provided user inputs.

