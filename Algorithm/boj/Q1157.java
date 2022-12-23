package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q1157 {
    public static void main(String[] args) throws IOException {
        StudyWord studyWord;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        studyWord = new StudyWord(word);

        studyWord.searchAlphabetToFindLetter();
        char theMostUsedLetter = studyWord.printTheMostUsedLetter();
        System.out.println(theMostUsedLetter);

    }
}

class StudyWord {
    private static final int toShiftASCII = 65;
    private static final char duplication = '?';
    private static final int numOfAlphabet = 26;

    private String word;
    private int[] alphabetASCIIArray = new int[numOfAlphabet];
    private int toCompareTmpLetter = 0;
    private boolean flagDuplication = true;
    private int theMostUsedLetterIdx;

    StudyWord(String word) {
        this.word = word;
    }

    private void countEachAlphabet(int i) {
        alphabetASCIIArray[word.charAt(i) - toShiftASCII]++;
    }

    void searchAlphabetToFindLetter() {
        for (int i = 0; i < word.length(); i++) {
            countEachAlphabet(i);
            findTheMostUsedLetter(i);
        }
    }

    private void findTheMostUsedLetter(int i) {
        if (toCompareTmpLetter == alphabetASCIIArray[word.charAt(i) - toShiftASCII]) {
            flagDuplication = true;
        }
        if (toCompareTmpLetter < alphabetASCIIArray[word.charAt(i) - toShiftASCII]) {
            toCompareTmpLetter = alphabetASCIIArray[word.charAt(i) - toShiftASCII];
            theMostUsedLetterIdx = i;
            flagDuplication = false;
        }
    }

    char printTheMostUsedLetter() {
        if (!flagDuplication) {
            char theMostUsedLetter = word.charAt(theMostUsedLetterIdx);
            return theMostUsedLetter;
        }
        return duplication;
    }
}
