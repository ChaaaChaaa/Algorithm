package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Q47 {
    public int[] q47(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j]; //뒤로 밀어라
                } else {
                    break;
                }
            }
            System.out.println("test : "+j);
            System.out.println(Arrays.toString(arr));
            arr[j + 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Q47 q47 = new Q47();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : q47.q47(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
