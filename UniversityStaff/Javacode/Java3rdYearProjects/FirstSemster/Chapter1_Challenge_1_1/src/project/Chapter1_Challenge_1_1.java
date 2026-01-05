```java
import java.util.Scanner;

public class CrypticMessageDecoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        // Validate input
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            scanner.close();
            return;
        }
        
        // Extract last digit
        int lastDigit = number % 10;
        
        // Extract first digit using log10
        int numDigits = (int) (Math.log10(number) + 1);
        int firstDigit = number / (int) Math.pow(10, numDigits - 1);
        
        // Extract second and second-last digits
        int secondDigit = (number / (int) Math.pow(10, numDigits - 2)) % 10;
        int secondLastDigit = (number / 10) % 10;
        
        // Calculate product and sum
        int product = firstDigit * lastDigit;
        int sum = secondDigit + secondLastDigit;
        
        // Concatenate to form final code
        String finalCode = "" + product + sum;
        
        // Output result
        System.out.println("The decrypted code is: " + finalCode);
        
        scanner.close();
    }
}
```
