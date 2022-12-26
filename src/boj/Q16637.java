package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Q16637 {
    private static int len;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        len = n / 2;
        String s = br.readLine();
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                nums.add(c - '0');
            } else {
                op.add(c);
            }
        }

        dfs(0, 0, nums, op);
        dfs(0, 1, nums, op);

        System.out.println(max);

    }

    public static void dfs(int currentDepth, int flag, LinkedList<Integer> n, LinkedList<Character> c) {
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        nums.addAll(n);
        op.addAll(c);


        if (currentDepth > op.size() - 1 || currentDepth > len - 1) {
           // System.out.println("IN currentDepth : "+currentDepth+" op.size() :"+op.size()+" len - 1 :"+(len - 1));
            while (nums.size() > 1) {
                cal(nums, op, 0);
            }
            max = Math.max(nums.get(0), max);
            return;
        }

        if (flag == 1) {
            cal(nums, op, currentDepth);
        }

        dfs(currentDepth + 1, 1, nums, op);
        dfs(currentDepth + 1, 0, nums, op);
    }


    public static void cal(LinkedList<Integer> n, LinkedList<Character> c, int index) {
        char op = c.remove(index);
        int num1 = n.remove(index);
        int num2 = n.remove(index);

        if (op == '+') {
            n.add(index, num1 + num2);
        } else if (op == '-') {
            n.add(index, num1 - num2);
        } else if (op == '*') {
            n.add(index, num1 * num2);
        }
    }
}
