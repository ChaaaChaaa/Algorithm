package inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q33 {
    public ArrayList<Integer> q33(int n, int k, int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < k - 1; i++) { //0부터 시작하니까 k-1
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) { //k일째 매출액
            hashMap.put(arr[rt], hashMap.getOrDefault(arr[rt], 0) + 1);
            ans.add(hashMap.size()); //매출액 종류니까 size를 저장
            hashMap.put(arr[lt], hashMap.get(arr[lt] - 1)); //window에서 벗어나니까 counting 하나 뺌
            if (hashMap.get(arr[lt]) == 0) {
                hashMap.remove(arr[lt]); //window안에 그 매출액이 없으므로 지운다.
            }
            lt++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q33 q33 = new Q33();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : q33.q33(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}
