import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class CA3_Question4 {

    public static boolean validate(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        Stack<String> tags = new Stack<>();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] lineTags = line.split(" ");

            for (String tag : lineTags) {
                if (tag.startsWith("</")) {
                    if (tags.isEmpty() || !tags.pop().equals(tag.replace("/", ""))) {
                        return false;
                    }
                } else {
                    tags.push(tag);
                }
            }
        }

        return tags.isEmpty();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"C:\\Users\\wikto\\oop-ca3-Wiktor-Teter\\CA3_Starter_Code\\tags_valid.txt", "C:\\Users\\wikto\\oop-ca3-Wiktor-Teter\\CA3_Starter_Code\\tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }
}