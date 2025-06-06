import java.util.Scanner;
public class AntMovement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of moves: ");
        int n = sc.nextInt();
        int[] moves = new int[n];
        System.out.println("Enter the moves (1 for right, -1 for left):");
        for (int i = 0; i < n; i++) {
            moves[i] = sc.nextInt();
        }
        int position = 0;
        int count = 0;
        for (int move : moves) {
            position += move;
            if (position == 0) {
                count++;
            }
        }
        System.out.println("The ant returned to the original position " + count + " times.");
    }
}