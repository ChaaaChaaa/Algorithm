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
        st = new StringTokenizer(br.readLine());
        br.close();

        int[] inputArr = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        NumberOfK numberOfK = new NumberOfK(findIndexNum);

        numberOfK.quickSort(inputArr, 0, inputArr.length - 1);

        System.out.println(numberOfK.printToFindIdxNum(inputArr, findIndexNum));


    }
}

class NumberOfK {
    private int findIndexNum;

    NumberOfK(int findIndexNum){
        this.findIndexNum = findIndexNum;
    }

    private int partition(int[] inputArr, int begin, int end) {
        int R, L, pivot;
        L = begin;
        R = end;
        pivot = (begin + end) / 2;

        while (L < R) {
            while ((L < R) && (inputArr[L] < inputArr[pivot])) {
                L++;
            }
            while ((L < R) && (inputArr[R] >= inputArr[pivot])) {
                R--;
            }
            if (L < R) {
                swap(inputArr, L, R);
                if (L == pivot) {
                    R = pivot;
                }
            }
        }
        swap(inputArr, pivot, R);
        return R;
    }

    private void swap(int[] inputArr, int idx1, int idx2) {
        int temp = inputArr[idx1];
        inputArr[idx1] = inputArr[idx2];
        inputArr[idx2] = temp;
    }

    void quickSort(int[] inputArr, int begin, int end) {
        if (begin < end) {
            int p;
            p = partition(inputArr, begin, end);
           if(p+1 == findIndexNum){
               return;
           }
          else if(p+1 < findIndexNum){
               quickSort(inputArr,p+1,end);
           }
          else
               quickSort(inputArr,begin,p-1);
        }
    }

    int printToFindIdxNum(int[] inputArr, int findIdxNum) {
        return inputArr[findIdxNum - 1];
    }
}
