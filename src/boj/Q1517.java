package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1517 {
    public static long[] sortedArr;
    private static long swap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arraySize = Integer.parseInt(st.nextToken());

        long[] inputArr = new long[arraySize];
        // 합치는 과정에서 정렬하여 원소를 담을 임시배열
        sortedArr= new long[arraySize];
        swap = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arraySize; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(inputArr, 0, inputArr.length - 1);
        System.out.println(swap);
    }

    public static void mergeSort(long[] arr, int left, int right){
        if(left == right){
            return;
        }
        int middle = (left+right)/2;
        mergeSort(arr,left,middle);
        mergeSort(arr,middle+1,right);
        mergeSortTwoArea(arr,left,middle,right);
    }

    private static void mergeSortTwoArea(long[] arr, int left, int middle, int right){
        int moveFromLeft = left; // 왼쪽 부분리스트 시작점
        int moveFromRight = middle+1; // 오른쪽 부분리스트의 시작점
        int index = left; // 채워넣을 배열의 인덱스


        while (moveFromLeft<=middle && moveFromRight <= right){
            /*
             *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
             *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
             */

            if(arr[moveFromLeft] <= arr[moveFromRight]){
                sortedArr[index++] = arr[moveFromLeft++];
            }

            /*
             *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
             *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
             */

            else{
                sortedArr[index++] = arr[moveFromRight++];
                swap += middle-moveFromLeft+1;
            }
        }

        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
         * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */

        while (moveFromLeft<=middle){
            sortedArr[index++] = arr[moveFromLeft++];
        }

        /*
         * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
         * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
         * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        while (moveFromRight<=right){
            sortedArr[index++] = arr[moveFromRight++];
        }


        for(int i=left; i<=right; i++){
            arr[i] = sortedArr[i]; //정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
        }
    }

}


