package testCases;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateWiseFileMover {

    public static void main(String[] args) {
        // Define source file path
        String sourceFilePath = "path/to/source/directory/filename.xls";
        
        // Get current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        
        // Define destination directory path with the current date
        String destinationDirPath = "path/to/destination/directory/" + currentDate;

        // Create Path objects
        Path sourcePath = Paths.get(sourceFilePath);
        Path destinationPath = Paths.get(destinationDirPath, sourcePath.getFileName().toString());

        // Ensure destination directory exists
        File destinationDir = new File(destinationDirPath);
        if (!destinationDir.exists()) {
            if (destinationDir.mkdirs()) {
                System.out.println("Destination directory created: " + destinationDirPath);
            } else {
                System.out.println("Failed to create destination directory: " + destinationDirPath);
                return;
            }
        }

        // Move the file
        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully to " + destinationPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
