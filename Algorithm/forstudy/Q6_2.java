package forstudy;

import java.util.Scanner;

public class Q6_2 {
    public int[] solution(int n, int[] arr) {
       for(int i=0; i<n-1; i++){
           for(int j=0; j<n-1-i; j++){
               if(arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }
        return arr;
    }

    public static void main(String[] args) {
        Q6_2 q6_2 = new Q6_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : q6_2.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

}
