package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Q25 {
    public ArrayList<Integer> q25(int n, int m, int[] arr, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr[p1] < arr2[p2]) {
                answer.add(arr[p1++]);
            } else {
                answer.add(arr2[p2++]);
            }
        }
        while (p1 < n) { //다 돌리고 둘중 남은게 하나만 있을꺼니 p1,p2순서 상관없음         
            answer.add(arr[p1++]);
        }
        while (p2 < m) {            
            answer.add(arr2[p2++]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Q25 q25 = new Q25();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int x : q25.q25(n, m, arr, arr2)) {
            System.out.print(x + " ");
        }
    }
}

