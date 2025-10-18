```java
import java.util.Random;
import java.util.Scanner;

public class DungeonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int health = 100;
        boolean defeated = false;
        
        // Simulate 5 rooms
        for (int room = 1; room <= 5; room++) {
            System.out.println("Entering room " + room + "...");
            int event = rand.nextInt(3) + 1;
            
            switch (event) {
                case 1: // Trap
                    health -= 20;
                    System.out.println("A trap sprung! Health is now " + health + ".");
                    break;
                case 2: // Healing potion
                    health += 15;
                    if (health > 100) health = 100; // Cap at 100
                    System.out.println("You found a healing potion! Health is now " + health + ".");
                    break;
                case 3: // Monster
                    int target = rand.nextInt(5) + 1;
                    System.out.println("A monster appears! Guess a number (1-5) to defeat it: ");
                    int guess;
                    do {
                        guess = scanner.nextInt();
                        if (guess < 1 || guess > 5) {
                            System.out.println("Invalid guess! Try again (1-5): ");
                        } else if (guess != target) {
                            System.out.println("Wrong! Try again: ");
                        }
                    } while (guess != target);
                    System.out.println("You defeated the monster!");
                    break;
            }
            
            // Check if defeated
            if (health <= 0) {
                System.out.println("You have been defeated in room " + room + ".");
                defeated = true;
                break;
            }
        }
        
        // Check for victory
        if (!defeated) {
            System.out.println("You cleared the dungeon! Victorious with " + health + " health!");
        }
        
        scanner.close();
    }
}
```
