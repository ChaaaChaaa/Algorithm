package boj;

import java.util.Scanner;

public class Q2743 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        MeasureWordLength measureWordLength = new MeasureWordLength(word);
        measureWordLength.printWordLength();

    }
}

class MeasureWordLength {
    private String word;

    MeasureWordLength(String word) {
        this.word = word;
    }

    private boolean measureWordLength() {
        return word.length() == 0;
    }

    void printWordLength() {
        if (measureWordLength()) {
            System.out.println(0);
            return;
        }
        System.out.println(word.length());
    }
}
