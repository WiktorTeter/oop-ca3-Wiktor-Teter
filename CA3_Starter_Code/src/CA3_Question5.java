import java.util.Queue;
import java.util.LinkedList;
/**
 *  Name:Wiktor Teter
 *  Class Group: SD2B
 */

public class CA3_Question5 {
    private Queue<String> takeoffQueue;
    private Queue<String> landingQueue;

    public CA3_Question5() {
        takeoffQueue = new LinkedList<>();
        landingQueue = new LinkedList<>();
    }

    public void takeoff(String flightSymbol) {
        takeoffQueue.add(flightSymbol);
    }

    public void land(String flightSymbol) {
        landingQueue.add(flightSymbol);
    }

    public void next() {
        while (!landingQueue.isEmpty() || !takeoffQueue.isEmpty()) {
            if (!landingQueue.isEmpty()) {
                System.out.println("Land: " + landingQueue.poll());
            } else if (!takeoffQueue.isEmpty()) {
                System.out.println("Takeoff: " + takeoffQueue.poll());
            }
        }
        if (landingQueue.isEmpty() && takeoffQueue.isEmpty()){
            System.out.println("No flights in queue.");
        }
    }



    public void quit() {
        System.out.println("Simulation ended.");
    }

    public static void main(String[] args) {
        CA3_Question5 airport = new CA3_Question5();
        airport.takeoff("Flight-100");
        airport.takeoff("Flight-220");
        airport.land("Flight-320");
        airport.next();
    }
}