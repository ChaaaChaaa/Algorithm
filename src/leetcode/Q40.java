package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    public static void main(String[] args) {
        int[] candidates = {1, 1, 2, 3};
        int target = 3;

        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private static void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] candidate, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            System.out.println(tempList);
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidate.length; i++) {
                //System.out.println("i : " + i + " start: " + start + " remain : " + remain + " remain - candidate[i]: " + (remain - candidate[i]));

                if (i > start && candidate[i] == candidate[i - 1]) {
                    //System.out.println("drop : " + candidate[i]);
                    continue;
                }
//                if(i<=start ){
//                    System.out.println("not drop : "+candidate[i]);
//                }


                tempList.add(candidate[i]);
                //System.out.println("add : " + candidate[i] + " tempList : " + tempList);
                backTrack(list, tempList, candidate, remain - candidate[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
