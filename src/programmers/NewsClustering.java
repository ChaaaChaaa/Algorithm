package programmers;

import java.util.HashMap;

public class NewsClustering {
    public int solution(String str1, String str2) {

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        map1 = insertValue(str1, map1);
        map2 = insertValue(str2, map2);

        HashMap<String, Integer> inter = getInterSet(map1, map2);
        HashMap<String, Integer> union = getUnionSet(map1, map2);


        int num1 = sumHashmap(inter);
        int num2 = sumHashmap(union);

        int answer = getResult(num1, num2);

        return answer;

    }

    private boolean isIncludeString(String sub) {
        return sub.charAt(0) < 'a' || sub.charAt(0) > 'z' || sub.charAt(1) < 'a' || sub.charAt(1) > 'z';
    }

    private HashMap<String, Integer> insertValue(String str, HashMap<String, Integer> map) {
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            if (isIncludeString(sub)) {
                continue;
            }
            if (map.containsKey(sub)) {
                map.put(sub, map.get(sub) + 1);
            } else {
                map.put(sub, 1);
            }
        }
        return map;
    }

    private HashMap<String, Integer> getInterSet(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        HashMap<String, Integer> inter = new HashMap<>();

        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                System.out.println(Math.min(map1.get(s), map2.get(s)));
                inter.put(s, Math.min(map1.get(s), map2.get(s)));
            }
        }
        return inter;
    }

    private HashMap<String, Integer> getUnionSet(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        HashMap<String, Integer> union = new HashMap<>();

        for (String s : map1.keySet()) {
            union.put(s, map1.get(s));
        }

        for (String s : map2.keySet()) {
            if (union.containsKey(s)) {
                union.put(s, Math.max(map2.get(s), union.get(s)));
            } else {
                union.put(s, map2.get(s));
            }
        }
        return union;
    }


    private int sumHashmap(HashMap<String, Integer> hashMap) {
        int sum = 0;
        for (String s : hashMap.keySet()) {
            sum += hashMap.get(s);
        }
        return sum;
    }

    private int getResult(int num1, int num2) {
        int answer = 0;

        if (num1 == 0 && num2 == 0) {
            answer = 65536;
        } else {
            answer = (int) ((double) num1 / num2 * 65536);
        }
        return answer;
    }

    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();

        String str1 = "FRANCE";
        String str2 = "french";

        int result = newsClustering.solution(str1, str2);

        System.out.println(result);
    }
}
