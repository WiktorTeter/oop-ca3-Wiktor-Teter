import java.util.Stack;
import java.util.Scanner;

public class CA3_Question1 {
    private static Stack<Integer> driveway = new Stack<>();
    private static Stack<Integer> street = new Stack<>();

    public static void main(String[] args) {
        runSimulation();
    }

    public static void runSimulation() {
        boolean stopSimulation = false;

        while (!stopSimulation) {
            // Read user input
            int input = getUserInput();

            if (input > 0) {
                // Add car to the driveway
                driveway.push(input);
            } else if (input < 0) {
                // Retrieve car from the driveway
                int carToRetrieve = Math.abs(input);
                moveCarsToStreet(carToRetrieve);
                retrieveCarFromDriveway(carToRetrieve);
                moveCarsToDriveway();
            } else {
                // Stop the simulation
                stopSimulation = true;
            }

            // Print the state of the driveway and street
            printState();
        }
    }

    private static int getUserInput() {
        // Replace this with your own logic to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a car number to add to the driveway, or a negative number to retrieve a car, or 0 to stop the simulation:");
        return scanner.nextInt();
    }

    private static void moveCarsToStreet(int carToRetrieve) {
        while (!driveway.isEmpty() && driveway.peek() != carToRetrieve) {
            street.push(driveway.pop());
        }
    }

    private static void retrieveCarFromDriveway(int carToRetrieve) {
        if (!driveway.isEmpty() && driveway.peek() == carToRetrieve) {
            driveway.pop();
        }
    }

    private static void moveCarsToDriveway() {
        while (!street.isEmpty()) {
            driveway.push(street.pop());
        }
    }

    private static void printState() {
        System.out.println("Driveway: " + driveway);
        System.out.println("Street: " + street);
        System.out.println();
    }
}

