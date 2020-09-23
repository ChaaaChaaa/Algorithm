package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q22 {
    public String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            orders[i] = sort(orders[i]);
        }


        for (String s : orders) {
            int n = s.length();
            String[] arr = convertArray(s);
            boolean[] visited = new boolean[n];
            for (int i = 1; i <= n; i++) {
                // System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
                hashMap = combination(arr, visited, 0, n, i, hashMap);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>();

        for (int num : course) {
            for (String s : hashMap.keySet()) {
                Integer value = hashMap.get(s);
                if (value > num) {
                    arrayList.add(s);
                }
            }
        }

        String[] answer = new String[arrayList.size()];

        int index = 0;

        for (String s : arrayList) {
            answer[index] = s;
            index++;
        }

        return answer;
    }

    private String sort(String order) {
        char[] c = order.toCharArray();
        Arrays.sort(c);
        String test = new String(c);
        return test;
    }

    private String[] convertArray(String s) {
        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.substring(i, i + 1);
        }
        return arr;
    }

    private HashMap<String, Integer> combination(String[] arr, boolean[] visited, int start, int n, int r, HashMap<String, Integer> hashMap) {
        if (r == 0) {
            hashMap = print(arr, visited, n, hashMap);
            return hashMap;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, hashMap);
            visited[i] = false;
        }

        return hashMap;
    }

    HashMap<String, Integer> print(String[] arr, boolean[] visited, int n, HashMap<String, Integer> hashMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                //System.out.print(arr[i] + " ");
                sb.append(arr[i]);
                String key =  sort(sb.toString());
                //System.out.println(sb);
                if (!hashMap.containsKey(key)) {
                    hashMap.put(key, 1);
                } else {
                    Integer value = hashMap.get(key);
                    hashMap.put(key, value);
                }
            }

        }
        // System.out.println();
        return hashMap;
    }


    public static void main(String[] args) {
        String test = "XYZ";
        Q22 q2 = new Q22();
        int n = test.length();
        // q2.permute(test, 0,n-1);
        //  q2.test(test, 2);
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        for (String s : q2.solution(orders, course)) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
