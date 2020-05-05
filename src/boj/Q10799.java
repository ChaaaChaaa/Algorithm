package boj;//쇠막대기 문제


import java.util.Scanner;

public class Q10799 {
    private static final String DIVIDE = "0";
    private static final String INSERT = "(";
    private static final String SUBTRACT = ")";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();
        sentence = sentence.replace("()", DIVIDE);

        StackLaser q10799 = new StackLaser(sentence);

        for (int i = 0; i < sentence.length(); i++) {
            solve(q10799, sentence, i);
        }
        System.out.println(q10799.getNumOfIronBar());
    }

    private static void solve(StackLaser q10799, String sentence, int index) {
        q10799.insertWord(index, sentence.charAt(index));
        final String word = String.valueOf(q10799.getWord(index));
        if (word.equals(DIVIDE)) {
            q10799.splitIronBar();
            return;
        }
        if (word.equals(INSERT)) {
            q10799.push(sentence.charAt(index));
            return;
        }
        if (word.equals(SUBTRACT)) {
            q10799.pop();
        }
    }
}

class StackLaser {
    private int topOfIndex;
    private int ironBar;
    private char[] stackArr;

    StackLaser(String sentence) {
        this.topOfIndex = -1;
        this.ironBar = 0;
        stackArr = new char[sentence.length()];
    }

    public void push(char word) {
        topOfIndex++;
        stackArr[topOfIndex] = word;
    }

    public void pop() {
        ironBar++;
        stackArr[topOfIndex] = 0;
        topOfIndex--;
    }

    void splitIronBar() {
        ironBar += (topOfIndex + 1);
    }


    int getNumOfIronBar() {
        return ironBar;
    }

    void insertWord(int index, char data) {
        stackArr[index] = data;
    }

    char getWord(int index) {
        return stackArr[index];
    }
}
