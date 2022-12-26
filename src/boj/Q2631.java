package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2631 {
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int num : arr) {
            int position = lowerBound(num);

            if (position == list.size()) {
                list.add(num);
            } else {
                list.set(position, num);
            }
        }
        System.out.println(n - list.size());
    }



    static int lowerBound(int target) {
        int start = 0;
        int end = list.size();

        while(end > start) {
          int mid = (start+end) /2;
            if(list.get(mid) >= target) {
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return end;
    }
}
