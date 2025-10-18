Challenge 1.2: The Lottery Number Analyzer

Description:
This program analyzes a set of winning lottery numbers stored as strings with dashes. It removes the dashes, converts each number into an array of digits, calculates the sum and average of the digits, and identifies the ticket with the highest average digit value.

Example Input/Output:
Input: {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"}
Output:
Analyzing: 12-34-56-78-90
Digit Sum: 45, Digit Average: 4.5
Analyzing: 33-44-11-66-22
Digit Sum: 30, Digit Average: 3.0
Analyzing: 01-02-03-04-05
Digit Sum: 15, Digit Average: 1.5
The winning number with the highest average is: 12-34-56-78-90 with an average of 4.5

Reflection:
I learned how to manipulate strings and convert characters to integers using String.replace() and Character.getNumericValue(). Using both for and for-each loops was straightforward, but ensuring accurate average calculations required careful type casting. The challenge reinforced the importance of testing with different inputs to verify the highest average logic.
