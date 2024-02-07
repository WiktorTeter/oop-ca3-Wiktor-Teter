import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *  Name:Wiktor Teter
 *  Class Group: SD2B
 */

public class CA3_Question3 {
    public static void main(String[] args) throws FileNotFoundException {
        readFile("CA3_Starter_Code/src/CA3_Question4.java");
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        Map<String, List<Integer>> identifiers = new HashMap<>();

        int lineNumber = 1;
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[^A-Za-z0-9_]+");

            while (lineScanner.hasNext()) {
                String identifier = lineScanner.next();
                identifiers.putIfAbsent(identifier, new ArrayList<>());
                identifiers.get(identifier).add(lineNumber);
            }

            lineNumber++;
        }

        for (Map.Entry<String, List<Integer>> entry : identifiers.entrySet()) {
            System.out.println("Identifier: " + entry.getKey() + ", Line: " + entry.getValue());
        }
    }
}