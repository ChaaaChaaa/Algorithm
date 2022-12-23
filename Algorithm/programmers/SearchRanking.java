package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SearchRanking {
    String[][] items = {{"cpp", "java", "python"}, {"frontend", "backend"}, {"junior", "senior"}, {"pizza", "chicken"}};

    public Integer[] solution(String[] info, String[] query) {
        List<Integer> ans = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (String str : info) {
            String[] s = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(s[i]);
            }

            int score = Integer.parseInt(s[4]);
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(score);
        }

        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            Collections.sort(e.getValue());
        }

        for (String q : query) {
            q = q.replaceAll(" and", "");
            String[] s = q.split(" ");
            int score = Integer.parseInt(s[4]);
            Set<String> result = new TreeSet<>();
            parse("", s, 0, result);
            int cnt = 0;
            for (String str : result) {
                List<Integer> list = map.get(str);
                if (list == null) {
                    continue;
                }
                cnt += binarySearch(list, score);
            }
            ans.add(cnt);
        }
        return ans.toArray(new Integer[0]);
    }

    private void parse(String current, String[] query, int depth, Set<String> result) {
        if (depth == query.length - 1) {
            result.add(current);
            return;
        }
        if (query[depth].equals("-")) {
            for (String s : items[depth]) {
                parse(current + s, query, depth + 1, result);
            }
        } else {
            parse(current + query[depth], query, depth + 1, result);
        }
    }

    private int binarySearch(List<Integer> list, int num) {
        int s = 0;
        int e = list.size();

        while (s < e) {
            int mid = (s + e) / 2;
            if (list.get(mid) >= num) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return list.size() - e;
    }
}
