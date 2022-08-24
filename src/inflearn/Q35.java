package inflearn;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Q35 {
    public int q35(int[] arr, int n, int k) {
        int ans = 0;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder()); //중복제거, 정렬까지함
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { //중복하면 안되니까 i+1부터 돈다
                for (int l = j + 1; l < n; l++) {
                    treeSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : treeSet) {
            cnt++;
            if (cnt == k) {
                return x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q35 q35 = new Q35();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(q35.q35(arr, n, k));
    }
}
