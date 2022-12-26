package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2529_Permutation {
    private static ArrayList<String> list = new ArrayList<>();
    private static int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static String[] inequalities = new String[9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i = 0; i < k; i++) {
            inequalities[i] = st.nextToken();
        }

        permutation(nums, 0, k + 1);

        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        sb.append(list.get(list.size() - 1)).append("\n");
        sb.append(list.get(0));

        System.out.println(sb.toString());
    }

    public static void permutation(int[] nums, int depth, int k) {
        if (depth >= 2) {
            if (inequalities[depth - 2].equals("<") && nums[depth - 2] > nums[depth - 1]) {
                return;
            } else if (inequalities[depth - 2].equals(">") && nums[depth - 2] < nums[depth - 1]) {
                return;
            }
        }

        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(nums[i]);
            }

            list.add(sb.toString());
            return;
        }

        for (int i = depth; i < nums.length; i++) {
            swap(nums, i, depth);
            permutation(nums, depth + 1, k);
            swap(nums, i, depth);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
