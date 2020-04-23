import java.io.*;
import java.util.Scanner;

public class Q6603_Recursion {
    private static final int MAX = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Lotto_Recursion lottoRecursion;

        while (true) {
            int k = sc.nextInt();
            int[] inputArray = new int[k];

            if (k == 0) {
                break;
            }

            for (int i = 0; i < k; i++) {
                inputArray[i] = sc.nextInt();
            }

            lottoRecursion = new Lotto_Recursion(k, inputArray);

            lottoRecursion.recursion(0, 0);
            System.out.println();

        }
    }


}

class Lotto_Recursion {
    private static final int MAX = 6;
    private static final int NEXT = 1;


    private int[] answer = new int[MAX];
    private boolean[] check;
    private int[] inputArray;
    private int k;

    Lotto_Recursion(int k, int[] inputArray) {
        this.k = k;
        check = new boolean[k];
        this.inputArray = inputArray;
    }

    void recursion(int prev, int index) {

        if (index == MAX) {
            for (int num : answer) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = prev; i < k; i++) {
            if (!check[i]) {
                check[i] = true;
                answer[index] = inputArray[i];
                recursion(i, index + NEXT);
                check[i] = false;
            }
        }
    }

}


