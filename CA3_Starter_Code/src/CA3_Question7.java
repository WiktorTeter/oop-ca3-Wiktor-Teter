import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Block2 {
    int quantity;
    double price;

    Block2(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}

public class CA3_Question7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Queue<Block2>> blocksMap = new HashMap<>();
        String command = "";

        do {
            System.out.println("Enter 'buy' to buy a block, 'sell' to sell a block, or 'quit' to end the simulation.");
            System.out.print(">");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                System.out.println("Enter the stock symbol:");
                String symbol = in.next();
                System.out.println("Enter the quantity you want to buy:");
                int quantity = in.nextInt();
                System.out.println("Enter the price you want to buy at:");
                double price = in.nextDouble();

                blocksMap.putIfAbsent(symbol, new LinkedList<>());
                blocksMap.get(symbol).add(new Block2(quantity, price));
            } else if (command.equalsIgnoreCase("sell")) {
                System.out.println("Enter the stock symbol:");
                String symbol = in.next();
                if (!blocksMap.containsKey(symbol)) {
                    System.out.println("No blocks available for this symbol.");
                    continue;
                }

                System.out.println("Enter the quantity you want to sell:");
                int quantity = in.nextInt();
                System.out.println("Enter the price you want to sell at:");
                double sellPrice = in.nextDouble(); // Added sell price input
                double totalGain = 0;

                Queue<Block2> blocks = blocksMap.get(symbol);
                while (quantity > 0 && !blocks.isEmpty()) {
                    Block2 block = blocks.peek();

                    if (block.quantity <= quantity) {
                        totalGain += block.quantity * (sellPrice - block.price); // Used sell price in calculation
                        quantity -= block.quantity;
                        blocks.poll();
                    } else {
                        totalGain += quantity * (sellPrice - block.price); // Used sell price in calculation
                        block.quantity -= quantity;
                        quantity = 0;
                    }
                }

                System.out.println("Total gain: " + totalGain);
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}