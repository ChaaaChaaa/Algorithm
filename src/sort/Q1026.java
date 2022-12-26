package sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        br.close();

        int[] arrayA = new int[n];
        int[] arrayB = new int[n];

        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(stA.nextToken());
            arrayB[i] = Integer.parseInt(stB.nextToken());
        }

        Treasure treasure = new Treasure(arrayA, arrayB, n);
        treasure.bubbleSort();
        System.out.println(treasure.resultMin());

    }
}

class Treasure {
    private int[] arrayA;
    private int[] arrayB;
    private int size;


    Treasure(int[] arrayA, int[] arrayB, int n) {
        this.arrayA = arrayA;
        this.arrayB = arrayB;
        size = n;
    }

    void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayA[j] > arrayA[j + 1]) {
                    sortOrder(j, arrayA);
                }
                if (arrayB[j] < arrayB[j + 1]) {
                    sortOrder(j, arrayB);
                }
            }
        }
    }

    private void sortOrder(int j, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
    }

    int resultMin() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += arrayA[i] * arrayB[i];
        }
        return result;
    }


}

