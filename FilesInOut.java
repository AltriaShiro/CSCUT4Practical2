import java.io.*;
import java.util.*;

public class FilesInOut {
    public static void main(String[] args) {
        // Read input file
        File inputFile = new File("C:\\Users\\Cris\\git\\CSCUT4Practical2\\input.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Reading Names and Lines
        List<String> formattedLines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            StringBuilder formattedName = new StringBuilder();
            
            // Format Name
            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                if (i == 0) {
                    formattedName.append(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
                } else if (i == 1 && word.length() == 2) {
                    formattedName.append(". ").append(word.toUpperCase());
                } else {
                    formattedName.append(" ").append(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
                }
            }

            formattedLines.add(formattedName.toString());
        }

        scanner.close();

        // Write formatted output to file
        File outputFile = new File("output.txt");
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(outputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String formattedLine : formattedLines) {
            writer.println(formattedLine);
        }

        writer.close();
    }
}
