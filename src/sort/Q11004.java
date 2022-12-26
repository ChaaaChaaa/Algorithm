package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arraySize = Integer.parseInt(st.nextToken());
        int findIndexNum = Integer.parseInt(st.nextToken());

        long[] inputArr = new long[arraySize];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arraySize; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        NumberOfK numberOfK = new NumberOfK(arraySize);
        numberOfK.mergeSort(inputArr, 0, arraySize - 1);
        long result = numberOfK.printToFindIdxNum(inputArr, findIndexNum);
        System.out.println(result);
    }
}

class NumberOfK {
    private long[] sortedArr;

    NumberOfK(int arraySize) {
        sortedArr = new long[arraySize];
    }

    void mergeSort(long[] inputArr, int left, int right) {
        int middle = (left + right) / 2;
        if (left < right) {

            mergeSort(inputArr, left, middle);
            mergeSort(inputArr, middle + 1, right);
            mergeTwoArea(inputArr, left, middle, right);
        }
    }

    private void mergeTwoArea(long[] inputArr, int left, int middle, int right) {
        int moveFromLeft = left;
        int sortedIdx = left;
        int moveFromRight = middle + 1;

        while (moveFromLeft <= middle && moveFromRight <= right) {
            if (inputArr[moveFromLeft] <= inputArr[moveFromRight]) {
                sortedArr[sortedIdx++] = inputArr[moveFromLeft++];
            } else {
                sortedArr[sortedIdx++] = inputArr[moveFromRight++];
            }
        }

        if (moveFromLeft > middle) {
            for (int i = moveFromRight; i <= right; i++) {
                sortedArr[sortedIdx++] = inputArr[i];
            }
        } else {
            for (int i = moveFromLeft; i <= middle; i++) {
                sortedArr[sortedIdx++] = inputArr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            inputArr[i] = sortedArr[i];
        }
    }

    long printToFindIdxNum(long[] inputArr, int findIdxNum) {
        return inputArr[findIdxNum - 1];
    }
}
