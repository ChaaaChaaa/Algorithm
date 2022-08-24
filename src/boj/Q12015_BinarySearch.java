package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q12015_BinarySearch {
    private static int[] nums;
    private static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        nums = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            if (list.isEmpty() || nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = binarySearch(list.size(), nums[i]);
                list.set(index, nums[i]);
            }
        }
        System.out.println(list.size());
    }

    private static int binarySearch(int end, int find) {
        int start = 0;
        int mid=0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (find < list.get(mid)) {
                end = mid - 1;
            } else if (find > list.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
