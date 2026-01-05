
package project.pkg2;

public class Chapter1_Challenge_1_2 {
   
    public static void main(String[] args) {
        // Step 1: Initialize the array
        String[] winningNumbers = {
            "12-34-56-78-90",
            "33-44-11-66-22",
            "01-02-03-04-05"
        };

        String winningWithHighestAvg = "";
        double highestAvg = 0.0;

        // Step 2: Analyze each number
        for (String ticket : winningNumbers) {
            System.out.println("Analyzing: " + ticket);

            // Remove dashes to get continuous string
            String continuous = ticket.replace("-", "");

            // Convert to char array
            char[] digits = continuous.toCharArray();

            // Create int array and compute sum
            int sum = 0;
            for (char digit : digits) {
                sum += Character.getNumericValue(digit);
            }

            // Calculate average
            double average = (double) sum / digits.length;

            // Print sum and average
            System.out.println("Digit Sum: " + sum + ", Digit Average: " + average);

            // Track the ticket with the highest average
            if (average > highestAvg) {
                highestAvg = average;
                winningWithHighestAvg = ticket;
            }
        }

        // Step 3: Announce the ticket with the highest average
        System.out.println("The winning number with the highest average is: " 
            + winningWithHighestAvg + " with an average of " + highestAvg);
    }
}


