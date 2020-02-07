package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        QuickSortSwapCount quickSortSwapCount = new QuickSortSwapCount();
        quickSortSwapCount.quickSort(inputArr, 0, inputArr.length - 1);
        System.out.println(quickSortSwapCount.result());
    }
}

class QuickSortSwapCount {
    private int countSwap = 0;

    private int partition(int[] quickArr, int begin, int end) {
        int pivot, L, R;
        L = begin;
        R = end;
        pivot = (begin + end) / 2;

        while (L < R) {
            while (L < R && quickArr[L] < quickArr[pivot]) {
                L++;
            }
            while (L < R && quickArr[R] >= quickArr[pivot]) {
                R--;
            }

            if (L < R) {
                swap(quickArr, L, R);
                if (L == pivot) {
                    R = pivot;
                }
            }
        }
        swap(quickArr, pivot, R);
        return R;
    }

    private void swap(int[] quickArr, int idx1, int idx2) {
        countSwap++;
        int temp = quickArr[idx1];
        quickArr[idx1] = quickArr[idx2];
        quickArr[idx2] = temp;
    }

    void quickSort(int[] quickArr, int begin, int end) {
        if (begin < end) {
            int p = partition(quickArr, begin, end);
            quickSort(quickArr, begin, p - 1);
            quickSort(quickArr, p + 1, end);
        }
    }

    int result() {
        return countSwap;
    }
}
