Challenge 1.3: The Dungeon Game

Description: This program simulates a text-based dungeon game where a player navigates 5 rooms, facing random events (traps, healing potions, or monsters). The player’s health is updated based on events, and they must guess a number to defeat monsters. The game ends if health reaches 0 or all rooms are cleared.

Example Input/Output: Output: Entering room 1... You found a healing potion! Health is now 100. Entering room 2... A monster appears! Guess a number (1-5) to defeat it: 3 Wrong! Try again: 4 You defeated the monster! ... You cleared the dungeon! Victorious with 80 health! OR Entering room 3... A trap sprung! Health is now 0. You have been defeated in room 3.

Reflection: I learned how to use Random for event generation and Scanner for user input in a do-while loop. The switch statement made event handling clean. The hardest part was ensuring health didn’t exceed 100 for potions and handling invalid guesses grac

