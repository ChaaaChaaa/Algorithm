package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Q1786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String baseString = br.readLine();
        String compareString = br.readLine();

        ArrayList<Integer> list = KMP(baseString, compareString);
        int size = list.size();

        System.out.println(size);

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    private static int[] getPi(String compareString) {
        int[] pi = new int[compareString.length()];
        int j = 0;
        for (int i = 1; i < compareString.length(); i++) {
            while (j > 0 && compareString.charAt(i) != compareString.charAt(j)) {
                j = pi[j - 1];
            }
            if (compareString.charAt(i) == compareString.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    private static ArrayList<Integer> KMP(String baseString, String compareString) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] pi = getPi(compareString);
        int j = 0;
        for (int i = 0; i < baseString.length(); i++) {
            while (j > 0 && baseString.charAt(i) != compareString.charAt(j)) {
                j = pi[j - 1];
            }

            if (baseString.charAt(i) == compareString.charAt(j)) {
                if (j == compareString.length() - 1) {
                    //  ++ans;
                    list.add(i - j + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return list;
    }

}
