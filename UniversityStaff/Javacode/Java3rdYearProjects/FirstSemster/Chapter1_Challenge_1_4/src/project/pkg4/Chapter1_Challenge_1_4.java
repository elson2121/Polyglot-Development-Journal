
package project.pkg4;
   import java.io.*;
// Custom exception class
class InvalidConfigVersionException extends Exception {
    public InvalidConfigVersionException(String message) {
        super(message);
    }
}

public class Chapter1_Challenge_1_4 {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            // Step 1: Try to open config.txt
            File configFile = new File("config.txt");
            reader = new BufferedReader(new FileReader(configFile));

            // Step 2: Read first line and parse to integer
            String versionLine = reader.readLine();
            int version = Integer.parseInt(versionLine);

            // Step 3: Check config version
            if (version < 2) {
                throw new InvalidConfigVersionException("Config version too old!");
            }

            // Step 4: Read second line as file path
            String filePath = reader.readLine();
            File pathFile = new File(filePath);

            if (!pathFile.exists()) {
                throw new IOException("The file path in config does not exist: " + filePath);
            }

            // If everything is fine
            System.out.println("Config loaded successfully.");
            System.out.println("Version: " + version);
            System.out.println("Path: " + filePath);
        }

        // Catch: Config file not found
        catch (FileNotFoundException e) {
            System.out.println("Error: config.txt file not found.");
        }

        // Catch: First line is not a number
        catch (NumberFormatException e) {
            System.out.println("Error: First line in config.txt is not a valid number.");
        }

        // Catch: Version check failed
        catch (InvalidConfigVersionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Catch: General I/O issues
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Always executes
        finally {
            System.out.println("Config read attempt finished.");

            // Clean up
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing reader.");
            }
        }
    }
}


