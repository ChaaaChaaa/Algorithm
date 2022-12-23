package forstudy;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_5 {
    public String solution(int n, int[] arr) {
        String ans = "U";
        Arrays.sort(arr);

        for(int i=0; i<n-1; i++){
            if(arr[i] == arr[i+1]){
                return "D";
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Q6_5 q6_5 = new Q6_5();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(q6_5.solution(n, arr));
    }
}
