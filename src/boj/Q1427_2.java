package boj;

import java.util.*;

class Q1427_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - 48;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < (arr.length - i) - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for(int i=arr.length-1; i>=0; i--){
            System.out.print(arr[i]);
        }
    }

}
