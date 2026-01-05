1. Application Overview
The Personal Diary Manager is a sophisticated JavaFX desktop application designed for secure and organized digital journaling. It provides a modern graphical user interface (GUI) for users to create, read, update, and delete (CRUD) diary entries with advanced rich-text support.
2. Core Feature Set
Centralized Dashboard: A navigation panel providing a sortable, comprehensive list of all diary entries.
Rich Text Integration: An embedded HTMLEditor allows for full text formatting, including bold, italics, and custom fonts.
Entry Preview Mode: A read-only viewing mode using WebView for a clean reading experience.
Dynamic Search: A real-time filtering system to instantly locate entries by title or body text.
Adaptive Theme Support: A built-in toggle for seamless switching between Light and Dark modes.
Asynchronous Processing: Background file operations (Concurrency) powered by CompletableFuture ensure the UI remains smooth and responsive during saves.
Data Integrity: Features an Auto-Save function that triggers every 30 seconds to prevent data loss, alongside visual progress indicators for all file I/O tasks.
3. Technical Architecture & Design
Framework: JavaFX (chosen for its native support of modern UI components like WebView and HTMLEditor).
Design Pattern: Utilizes an MVC-inspired architecture to cleanly separate data models (DiaryEntry), business logic (DiaryManager), and UI presentation.
Storage Strategy: Employs a flat-file persistence system where each entry is saved as an individual text file, ensuring portability and simplicity.
Threading: Uses the JavaFX Timeline for scheduling auto-saves and CompletableFuture for non-blocking disk operations.
4. Execution & Setup (2026 Standards)
To run this application, ensure your environment meets the following requirements:
Environment: Requires JDK 17 or higher.
Launch Procedure:
Open the project in a modern IDE like IntelliJ IDEA or Eclipse.
Crucial Step: Execute the org.example.Launcher class to start the app.
Note: Do not run org.example.Main directly; the Launcher ensures all JavaFX runtime components are properly initialized.
5. Operational Guide
Creating Entries: Select "New Entry," compose your title and content, and hit "Save."
Editing: Locate an entry in the sidebar, click it to view, and select the "Edit" button to unlock the rich-text editor.
Deleting: Highlight an entry and use "Delete Entry" for permanent removal.
Searching: Type keywords into the persistent search bar to filter your entry list instantly.
Visuals: Click the "Dark Mode" toggle at any time to adjust the application’s aesthetic for low-light environments.