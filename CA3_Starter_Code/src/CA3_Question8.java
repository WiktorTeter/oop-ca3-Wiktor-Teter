import java.util.Scanner;
import java.util.Stack;

public class CA3_Question8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();
        System.out.println("Please enter one number or operator at a time, followed by the enter key. Enter 'q' to quit.\n Example:\n 5\n 3\n +\n>");
        boolean done = false;
        while (!done)
        {
            String input = in.next();

            if (input.equals("+"))
            {
                if (numbers.size() < 2) {
                    System.out.println("Error: Not enough numbers for operation.");
                    continue;
                }
                int result = numbers.pop() + numbers.pop();
                numbers.push(result);
                System.out.println("Result: " + result);
            } else if (input.equals("-"))
            {
                if (numbers.size() < 2) {
                    System.out.println("Error: Not enough numbers for operation.");
                    continue;
                }
                int result = -numbers.pop() + numbers.pop();
                numbers.push(result);
                System.out.println("Result: " + result);
            } else if (input.equals("*") || input.equals("x"))
            {
                if (numbers.size() < 2) {
                    System.out.println("Error: Not enough numbers for operation.");
                    continue;
                }
                int result = numbers.pop() * numbers.pop();
                numbers.push(result);
                System.out.println("Result: " + result);
            } else if (input.equals("/"))
            {
                if (numbers.size() < 2) {
                    System.out.println("Error: Not enough numbers for operation.");
                    continue;
                }
                int result = (int) (1/numbers.pop() * numbers.pop());
                numbers.push(result);
                System.out.println("Result: " + result);
            } else if (input.equalsIgnoreCase("q"))
            {
                done = true;
            } else {
                try {
                    numbers.push(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input.");
                }
            }
        }
    }
}