package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q401 {
    private static final int[] watch = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(readBinaryWatch(num));
    }

    private static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();

        if (num >= 0) {
            recursion(list, num, 0, 0, 0);
        }

        return list;
    }

    private static void recursion(List<String> list, int num, int hour, int minute, int start) {
        if (num <= 0) {
            if (hour < 12 && minute < 60) {
                if (minute < 10) {
                    list.add(hour + ":0" + minute);
                } else {
                    list.add(hour + ":" + minute);
                }
            }
        } else {
            for (int i = start; i < watch.length; i++) {
                if (i < 4) {
                    recursion(list, num - 1, hour + watch[i], minute, i + 1);
                } else {
                    recursion(list, num - 1, hour, minute + watch[i], i + 1);
                }
            }
        }
    }


}

