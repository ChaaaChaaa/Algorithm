package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q2902 {
    private static final String splitFromHyphens = "-";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] eachNameArr = br.readLine().split(splitFromHyphens);
        KMP kmp = new KMP(eachNameArr);
        kmp.printResult();
    }
}

class KMP {
    private static final int firstCharacterIdx = 0;
    private String[] eachNameArr;


    KMP(String[] eachNameArr) {
        this.eachNameArr = eachNameArr;
    }

    private StringBuilder pickFirstCharacter() {
        StringBuilder sb = new StringBuilder();
        for (String str : eachNameArr) {
            char firstCharacter = str.charAt(firstCharacterIdx);
            sb.append(firstCharacter);
        }
        return sb;
    }

    void printResult() {
        System.out.print(pickFirstCharacter());
    }
}
