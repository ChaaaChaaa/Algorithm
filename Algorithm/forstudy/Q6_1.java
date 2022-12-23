package forstudy;

import java.util.Scanner;

public class Q6_1 {
    public int[] solution(int n, int[] arr) {
       for(int i=0; i<n-1; i++){
           int index = i;
           for(int j=i+1; j<n; j++){
               if(arr[index] > arr[j]){
                   index = j;
               }
           }

           int temp = arr[i];
           arr[i] = arr[index];
           arr[index] = temp;
       }
       return arr;
    }

    public static void main(String[] args) {
        Q6_1 q6_1 = new Q6_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : q6_1.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
