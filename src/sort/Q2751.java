package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countNum = Integer.parseInt(br.readLine());
        int[] quickSortArr = new int[countNum];

        for (int i = 0; i < countNum; i++) {
            quickSortArr[i] = Integer.parseInt(br.readLine());
        }

        SortNumber3 sortNumber3 = new SortNumber3();
        int size = quickSortArr.length - 1;
        sortNumber3.quickSort(quickSortArr, 0, size);
        sortNumber3.printSort(quickSortArr);
        System.out.print(sortNumber3.sb);
    }
}

class SortNumber3 {

    private int partition(int begin, int end, int[] quickSortArr) {
        int left, right, pivot;
        left = begin;
        right = end;
        pivot = (begin + end) / 2;

        while (left < right) {
            while ((left < right) && (quickSortArr[pivot] > quickSortArr[left])) {
                left++;
            }
            while ((left < right) && (quickSortArr[pivot] <= quickSortArr[right])) {
                right--;
            }
            if (left < right) {
                swap(quickSortArr, left, right);
                if (left == pivot) {
                    pivot = right;
                }
            }
        }

        swap(quickSortArr, pivot, right);
        return right;
    }

    private void swap(int[] quickSortArr, int idx1, int idx2) {
        int temp = quickSortArr[idx1];
        quickSortArr[idx1] = quickSortArr[idx2];
        quickSortArr[idx2] = temp;
    }

    void quickSort(int[] quickSortArr, int begin, int end) {
        if (begin < end) {
            int pivot;
            pivot = partition(begin, end, quickSortArr);
            quickSort(quickSortArr, begin, pivot - 1);
            quickSort(quickSortArr, pivot + 1, end);
        }
    }

    StringBuilder sb;
    void printSort(int[] quickSortArr) {
        sb = new StringBuilder();
        for (int a : quickSortArr) {
           sb.append(a);
           sb.append("\n");
        }
    }
}
