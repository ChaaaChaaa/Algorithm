package boj;

import java.util.Scanner;
import java.util.Stack;

public class Q17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0; i<n; i++){
          while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
              arr[stack.pop()] = arr[i];
          }
          stack.push(i);
        }

        while (!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);

    }
}
