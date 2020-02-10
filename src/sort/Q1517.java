package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] inputArr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        MergeSortSwapCount mergeSortSwapCount = new MergeSortSwapCount(n);
        mergeSortSwapCount.mergeSort(inputArr, 0, n - 1);
        System.out.println(mergeSortSwapCount.printCount());

    }
}

class MergeSortSwapCount {
    private long countSwap = 0;
    private long[] sortedArr;

    MergeSortSwapCount(int n) {
        sortedArr = new long[n];
    }

    void mergeTwoArea(long[] unsorted, int left, int middle, int right) {
        int moveFromLeftArea = left;
        int sortedIdx = left;
        int moveFromRightArea = middle + 1;
        int i;

        while (moveFromLeftArea <= middle && moveFromRightArea <= right) {
            if (unsorted[moveFromLeftArea] <= unsorted[moveFromRightArea]) {
                sortedArr[sortedIdx] = unsorted[moveFromLeftArea++];
            } else {
                sortedArr[sortedIdx] = unsorted[moveFromRightArea++];
                countSwap += (middle + 1 - moveFromLeftArea);
            }
            sortedIdx++;
        }

        if (moveFromLeftArea > middle) {
            for (i = moveFromRightArea; i <= right; i++, sortedIdx++) {
                sortedArr[sortedIdx] = unsorted[i];
            }
        } else {
            for (i = moveFromLeftArea; i <= middle; i++, sortedIdx++) {
                sortedArr[sortedIdx] = unsorted[i];
            }
        }

        for (i = left; i <= right; i++) {
            unsorted[i] = sortedArr[i];
        }
    }

    void mergeSort(long[] unsorted, int left, int right) {

        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(unsorted, left, middle);
            mergeSort(unsorted, middle + 1, right);
            mergeTwoArea(unsorted, left, middle, right);
        }
    }

    long printCount() {
        return countSwap;
    }
}
