package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MenuRenewal {
    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            Arrays.toString(order);

            for (int eachCourse : course) {
                combination(order, sb, 0, 0, eachCourse);
            }
        }

        for (int eachCourse : course) {
            Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
            int max = 0;

            for (Map.Entry<String, Integer> entry : entrySet) {
                if (entry.getKey().length() == eachCourse) {
                    max = Math.max(max, entry.getValue());
                }
            }

            for (Map.Entry<String, Integer> entry : entrySet) {
                if (max > 1 && entry.getKey().length() == eachCourse && entry.getValue() == max) {
                    arrayList.add(entry.getKey());
                }
            }
        }

        Collections.sort(arrayList);
        String[] ans = new String[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            ans[i] = arrayList.get(i);
        }

        return ans;
    }

    private static void combination(char[] order, StringBuilder sb, int start, int count, int maxSize) {
        if (count == maxSize) {
            String key = sb.toString();
            hashMap.put(key, (hashMap.getOrDefault(key, 0) + 1));
            return;
        }

        for (int i = start; i < order.length; i++) {
            sb.append(order[i]);
            combination(order, sb, start + 1, count + 1, maxSize);
            sb.delete(count, count + 1);
        }
    }
}
