```java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {
    public static void main(String[] args) {
        BufferedReader reader = null;
        
        try {
            // Open and read config.txt
            reader = new BufferedReader(new FileReader("config.txt"));
            
            // Read version
            String versionLine = reader.readLine();
            if (versionLine == null) {
                throw new IOException("Config file is empty.");
            }
            int version = Integer.parseInt(versionLine.trim());
            
            // Check version
            if (version < 2) {
                throw new Exception("Config version too old!");
            }
            
            // Read file path
            String filePath = reader.readLine();
            if (filePath == null) {
                throw new IOException("Missing file path in config.");
            }
            
            // Check if file exists
            File file = new File(filePath.trim());
            if (!file.exists()) {
                throw new IOException("File at path '" + filePath + "' does not exist.");
            }
            
            System.out.println("Config read successfully: Version " + version + ", Path " + filePath);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: config.txt not found.");
        } catch (NumberFormatException e) {
            System.out.println("Error: First line must be a valid integer.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Config read attempt finished.");
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
```
