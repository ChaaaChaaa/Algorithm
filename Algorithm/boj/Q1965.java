package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1965 {
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

//        for (int i = 0; i < n; i++) {
//            int temp = Integer.parseInt(st.nextToken());
//            count[temp] = count[temp - 1] + 1;
//            if (count[temp] > max) {
//                max = count[temp];
//            }
//        }
//
//        System.out.println(n - max);


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int position = binarySearch(arr[i]);
            if (position == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(position, arr[i]);
            }
        }
        System.out.println(list.size());
    }


    private static int binarySearch(int target) {
        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}



