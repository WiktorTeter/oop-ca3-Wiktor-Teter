import java.util.Scanner;
import java.util.Stack;

/**
 *  Name:
 *  Class Group:
 */
class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class CA3_Question2
{
    public static int[][] initializeArray() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }



    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(r, c));
        int fillNumber = 1;

        while (!stack.isEmpty()) {
            Pair cell = stack.pop();

            if (arr[cell.row][cell.col] == 0) {
                arr[cell.row][cell.col] = fillNumber++;
                if (cell.row > 0) stack.push(new Pair(cell.row - 1, cell.col)); // North
                if (cell.col < arr[0].length - 1) stack.push(new Pair(cell.row, cell.col + 1)); // East
                if (cell.row < arr.length - 1) stack.push(new Pair(cell.row + 1, cell.col)); // South
                if (cell.col > 0) stack.push(new Pair(cell.row, cell.col - 1)); // West
            }
        }
    }

    public static void start()
    {
       int[][] arr = initializeArray();
       display(arr);
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the starting row and column for the flood fill:");
        int r = kb.nextInt();
        int c = kb.nextInt();
        fill(r, c, arr);
        display(arr);
    }
    public static void main(String[] args) {
        start();
    }

}
