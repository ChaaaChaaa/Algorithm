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

        SortNumber2 sortNumber2 = new SortNumber2();
        int size = quickSortArr.length - 1;
        sortNumber2.quickSort(quickSortArr, 0, size);
        sortNumber2.printSort(quickSortArr);
        System.out.print(sortNumber2.sb);
    }
}

class SortNumber2 {

    private int partition(int begin, int end, int[] quickSortArr) {
        int left, right, pivot;
        left = begin;
        right = end;
        pivot = (begin + end) / 2;

        while (left < right) {
            while (comparePivotAndLeft(left,right,pivot,quickSortArr)) {
                left++;
            }
            while (comparePivotAndRight(left,right,pivot,quickSortArr)) {
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

    private boolean comparePivotAndLeft(int left, int right, int pivot, int[] quickSortArr){
        return (left < right) && (quickSortArr[pivot] > quickSortArr[left]);
    }

    private boolean comparePivotAndRight(int left, int right, int pivot, int[] quickSortArr){
        return (left < right) && (quickSortArr[pivot] <= quickSortArr[right]);
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
