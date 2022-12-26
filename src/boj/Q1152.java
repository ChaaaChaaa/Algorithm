package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        NumOfWords numOfWords = new NumOfWords(sentence);

        numOfWords.deleteSpaces();
        numOfWords.makeArrSplitSpace();
        numOfWords.printCount();
    }
}

class NumOfWords {
    private String sentence;
    private String[] strArr;
    private String convertSpacesToOne;

    NumOfWords(String sentence) {
        this.sentence = sentence;
    }

    void deleteSpaces() {
        String removeSpace = sentence.trim();
        convertSpacesToOne = removeSpace.replace("\\p{Z}", " ");
        strArr = convertSpacesToOne.split(" ");
    }

    void makeArrSplitSpace() {
        strArr = convertSpacesToOne.split(" ");
    }

    private boolean checkBlankWord() {
        return strArr[0].length() == 0;
    }

    void printCount() {
        int count = strArr.length;

        if (checkBlankWord()) {
            System.out.println(count - 1);
            return;
        }
        System.out.println(count);
    }

}
