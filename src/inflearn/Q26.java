package inflearn;

import java.util.*;

public class Q26 {
    public ArrayList<Integer> q26(int n, int m, int[] arr, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        Arrays.sort(arr2);

        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr[p1] == arr2[p2]) {
                ans.add(arr[p1++]);
                p2++;
            } else if (arr[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q26 q26 = new Q26();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : q26.q26(n, m, arr, arr2)) {
            System.out.print(x + " ");
        }
    }
}
