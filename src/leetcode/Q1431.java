package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1431 {
    public static void main(String[] args) {
        int[] candies = {2, 3, 4, 5, 1, 3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));

    }

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNum = Integer.MIN_VALUE;
        List<Boolean> booleanList = new ArrayList<>();

        for (int candy : candies) {
            if (candy > maxNum) {
                maxNum = candy;
            }
        }

        for (int candy : candies) {
            if (candy + extraCandies >= maxNum) {
                booleanList.add(true);
            } else {
                booleanList.add(false);
            }
        }
        return booleanList;
    }
}
