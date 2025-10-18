Challenge 1.4: The Robust File Config Reader

Description: This program reads a configuration file (config.txt) containing a version number and a file path. It handles multiple exceptions (file not found, invalid number, I/O errors), checks if the version is at least 2, verifies the file path exists, and ensures a completion message is always printed.

Example Input/Output: Input (config.txt): 1 C:\nonexistent_folder\nonexistent_file.txt Output: Error: Config version too old! Config read attempt finished.

Reflection: I learned how to use multiple catch blocks and create a custom exception. Handling file I/O with BufferedReader and checking file existence with File.exists() was new. The most difficult part was ensuring all possible errors (missing file, invalid version, etc.) were caught without crashing the program.
