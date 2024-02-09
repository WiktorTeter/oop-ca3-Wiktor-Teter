import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Block {
    int quantity;
    double price;

    Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
}

public class CA3_Question6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Block> blocks = new LinkedList<>();
        String command = "";

        do {
            System.out.println("Enter 'buy' to buy a block, 'sell' to sell a block, or 'quit' to end the simulation.");
            System.out.print(">");
            command = in.next();

            if (command.equalsIgnoreCase("buy")) {
                System.out.println("Enter the quantity you want to buy:");
                int quantity = in.nextInt();
                System.out.println("Enter the price you want to buy at:");
                double price = in.nextDouble();
                blocks.add(new Block(quantity, price));
            } else if (command.equalsIgnoreCase("sell")) {
                System.out.println("Enter the quantity you want to sell:");
                int quantity = in.nextInt();
                System.out.println("Enter the price you want to sell at:");
                double sellPrice = in.nextDouble();
                double totalGain = 0;

                while (quantity > 0) {
                    Block block = blocks.peek();

                    if (block.quantity <= quantity) {
                        totalGain += block.quantity * (sellPrice - block.price);
                        quantity -= block.quantity;
                        blocks.poll();
                    } else {
                        totalGain += quantity * (sellPrice - block.price);
                        block.quantity -= quantity;
                        quantity = 0;
                    }
                }

                System.out.println("Total gain: " + totalGain);
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
}