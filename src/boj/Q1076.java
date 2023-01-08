package boj;

import java.util.HashMap;
import java.util.Scanner;

public class Q1076 {
    static final String[] colorName = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    public static void main(String[] args) {
        HashMap<String, Integer> colorMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            colorMap.put(colorName[i], i);
        }

        Scanner sc = new Scanner(System.in);
        String firstColor = sc.next();
        String secondColor = sc.next();
        String thirdColor = sc.next();

        StringBuilder sb = new StringBuilder();
        int firstNumber = colorMap.get(firstColor);
        int secondNumber = colorMap.get(secondColor);
        int maxIndex = colorMap.get(thirdColor);
        int thirdNumber = (int) Math.pow(10, maxIndex);
        String number = String.valueOf(sb.append(firstNumber).append(secondNumber));
        long ans = (long) Integer.parseInt(number) *thirdNumber;
        System.out.println(ans);
    }
}
