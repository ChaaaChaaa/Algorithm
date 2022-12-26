package forstudy;

import java.util.Scanner;

public class Q6_4 {
    public int[] solution(int size, int n, int[] arr) {
      int [] cache = new int[size];
      for(int x : arr){
          int position = -1;
          for(int i=0; i<size; i++){
              if(x == arr[i]){
                  position = i;
              }
          }

          if(position == -1){
              for(int i= size-1; i>1; i--){
                  cache[i] = cache[i-1];
              }
          }else{
              for(int i = position; i>1; i--){
                  cache[i] = cache[i-1];
              }
          }

          cache[0] = x;
      }
      return cache;
    }

    public static void main(String[] args) {
        Q6_4 q6_4 = new Q6_4();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : q6_4.solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}
