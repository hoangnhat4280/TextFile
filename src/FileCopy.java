import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileCopy <source file> <target file>");
            return;
        }

        String sourceFileName = args[0];
        String targetFileName = args[1];

        File sourceFile = new File(sourceFileName);
        File targetFile = new File(targetFileName);

        if (!sourceFile.exists()) {
            System.out.println("Error: Source file does not exist.");
            return;
        }

        if (targetFile.exists()) {
            System.out.println("Error: Target file already exists.");
            return;
        }

        try (Reader reader = new FileReader(sourceFile);
             Writer writer = new FileWriter(targetFile)) {

            int character;
            int characterCount = 0;

            while ((character = reader.read()) != -1) {
                writer.write(character);
                characterCount++;
            }

            System.out.println("Copied " + characterCount + " characters from " + sourceFileName + " to " + targetFileName);
        } catch (IOException e) {
            System.out.println("An error occurred while copying the file: " + e.getMessage());
        }
    }
}
