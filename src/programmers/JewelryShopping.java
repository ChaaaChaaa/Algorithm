package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class JewelryShopping {
    static Set<String> hashSet = new HashSet<>(); //보석의 종류의 개수 확인
    static Map<String, Integer> hashMap = new HashMap<>(); //보석의 종류의 개수 기록

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        //String [] gems = {"AA", "AB", "AC", "AA", "AC"};
        //String [] gems = {"XYZ", "XYZ", "XYZ"};
        //String [] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems) {
        for (int i = 0; i < gems.length; i++) {
            hashSet.add(gems[i]);
        }

        int start = 0;
        int tempStart = 0;
        int length = gems.length;

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < gems.length; i++) {
            hashMap.put(gems[i], hashMap.getOrDefault(gems[i], 0) + 1);

            queue.add(gems[i]);

            while (true) {
                String gem = queue.peek();
                if (hashMap.get(gem) > 1) { //해당 보석이 중복으로 들어왔다
                    hashMap.put(gem, hashMap.get(gem) - 1);
                    queue.poll();
                    tempStart++;
                } else {
                    break;
                }
            }

            if (hashMap.size() == hashSet.size()) { //모든 보석이 한번 이상씩 포함되었다는 뜻
                if (length > queue.size()) { //가장 짧은 구간을 구하기 위해서
                    length = queue.size();
                    start = tempStart;
                }
            }
        }

        return new int[]{start + 1, start + length};
    }
}
