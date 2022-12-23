package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
    public static List<Integer> partitionLabels(String s) {
        Integer[] positions = new Integer[26];
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            positions[chs[i] - 'a'] = i;
        }
        System.out.println(Arrays.toString(positions));

        List<Integer> resLS = new ArrayList<>();
        int pos = 0, end = 0, anchor = 0;
        while (pos < chs.length) {
            end = Math.max(positions[chs[pos] - 'a'], end);
            if (pos == end) {
                resLS.add(pos - anchor + 1);
                anchor = pos + 1;
            }
            pos++;
        }
        return resLS;
    }
}