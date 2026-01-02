import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.*;
import java.util.stream.Collectors;

public class DiaryManagerV2 {
    private static final String ENTRIES_DIR = "entries";
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // make the folder for files
            Files.createDirectories(Paths.get(ENTRIES_DIR));
            
            boolean running = true;
            while (running) {
                System.out.println("\n--- DIARY SYSTEM V2 ---");
                System.out.println("1. Write Note");
                System.out.println("2. Read Note");
                System.out.println("3. Search Word");
                System.out.println("4. Create Zip Backup");
                System.out.println("5. Stop Program");
                System.out.print("pick number: ");
                
                String cmd = input.nextLine();
                
                switch(cmd) {
                    case "1": writeNote(); break;
                    case "2": readNote(); break;
                    case "3": searchNotes(); break;
                    case "4": makeZip(); break;
                    case "5": running = false; break;
                    default: System.out.println("not a choice");
                }
            }
        } catch (IOException e) {
            System.out.println("folder error: " + e.getMessage());
        }
    }

    private static void writeNote() {
        // format time for the filename
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        String name = "diary_" + LocalDateTime.now().format(myFormat) + ".txt";
        Path path = Paths.get(ENTRIES_DIR, name);

        System.out.println("Write your text (type 'END' on its own line to save):");
        
        // buffered writer used here
        try (BufferedWriter out = Files.newBufferedWriter(path)) {
            while (true) {
                String line = input.nextLine();
                if (line.equalsIgnoreCase("END")) break;
                out.write(line);
                out.newLine();
            }
            System.out.println("saved to " + name);
        } catch (IOException e) {
            System.out.println("fail to write: " + e.getMessage());
        }
    }

    private static void readNote() {
        try {
            List<Path> allFiles = Files.list(Paths.get(ENTRIES_DIR)).collect(Collectors.toList());
            if (allFiles.isEmpty()) {
                System.out.println("nothing here yet");
                return;
            }

            for (int i = 0; i < allFiles.size(); i++) {
                System.out.println("[" + i + "] " + allFiles.get(i).getFileName());
            }

            System.out.print("pick a number: ");
            int id = Integer.parseInt(input.nextLine());
            
            // buffered reader used here
            try (BufferedReader in = Files.newBufferedReader(allFiles.get(id))) {
                String l;
                System.out.println("--- START ---");
                while ((l = in.readLine()) != null) {
                    System.out.println(l);
                }
                System.out.println("--- END ---");
            }
        } catch (Exception e) {
            System.out.println("read error: " + e.getMessage());
        }
    }

    private static void searchNotes() {
        System.out.print("search for: ");
        String target = input.nextLine().toLowerCase();
        
        try {
            Files.list(Paths.get(ENTRIES_DIR)).forEach(p -> {
                try {
                    String data = Files.readString(p).toLowerCase();
                    if (data.contains(target)) {
                        System.out.println("Found in " + p.getFileName());
                    }
                } catch (IOException e) { /* ignore single error */ }
            });
        } catch (IOException e) {
            System.out.println("search error");
        }
    }

    private static void makeZip() {
        String zipFile = "backup_diary.zip";
        try (ZipOutputStream z = new ZipOutputStream(new FileOutputStream(zipFile))) {
            Files.list(Paths.get(ENTRIES_DIR)).forEach(p -> {
                try {
                    z.putNextEntry(new ZipEntry(p.getFileName().toString()));
                    Files.copy(p, z);
                    z.closeEntry();
                } catch (IOException e) { }
            });
            System.out.println("zip made: " + zipFile);
        } catch (IOException e) {
            System.out.println("zip error: " + e.getMessage());
        }
    }
}
