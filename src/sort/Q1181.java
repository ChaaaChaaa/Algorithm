package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countNum = Integer.parseInt(br.readLine());

        String[] sortWords = new String[countNum];

        for (int i = 0; i < countNum; i++) {
            sortWords[i] = br.readLine();
        }

        SortOfWord sortOfWord = new SortOfWord(countNum);
        sortOfWord.mergeSort(sortWords, 0, sortWords.length - 1);
        sortOfWord.printArr(sortWords);

    }
}

class SortOfWord {
    private static final String NEW_LINE = "\n";
    private String[] sortWords;

    SortOfWord(int size) {
        sortWords = new String[size];
    }

    void mergeSort(String[] unSortWords, int left, int right) {
        int middle = (left + right) / 2;
        if (left < right) {
            mergeSort(unSortWords, left, middle);
            mergeSort(unSortWords, middle + 1, right);
            mergeTwoArea(unSortWords, left, middle, right);
        }
    }

    private void mergeTwoArea(String[] unSortWords, int left, int middle, int right) {
        int moveFromLeft = left;
        int sortedIdx = left;
        int moveFromRight = middle + 1;
        int i;

        while (moveFromLeft <= middle && moveFromRight <= right) {
            if (checkSameChar(unSortWords[moveFromLeft].toCharArray(), unSortWords[moveFromRight].toCharArray()) > 0) {
                sortWords[sortedIdx++] = unSortWords[moveFromLeft++];
            } else {
                sortWords[sortedIdx++] = unSortWords[moveFromRight++];
            }
        }

        if (moveFromLeft > middle) {
            for (i = moveFromRight; i <= right; i++) {
                sortWords[sortedIdx++] = unSortWords[i];
            }
        } else {
            for (i = moveFromLeft; i <= middle; i++) {
                sortWords[sortedIdx++] = unSortWords[i];
            }
        }

        for (i = left; i <= right; i++) {
            unSortWords[i] = sortWords[i];
        }
    }

    private int checkSameChar(char[] c1, char[] c2) {
        if (c1.length == c2.length) {
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i]) {
                    return c2[i] - c1[i];
                }
            }
            return 0;
        } else
            return c2.length - c1.length;
    }

    private StringBuilder skipSameWord(String[] unSortWords) {
        StringBuilder sb = new StringBuilder();
        String prevStr = "";
        for (String unSortWord : unSortWords) {
            if (prevStr.equals(unSortWord)) {
                continue;
            }
            sb.append(unSortWord).append(NEW_LINE);
            prevStr = unSortWord;
        }
        return sb;
    }

    void printArr(String[] unSortWords) {
        System.out.print(skipSameWord(unSortWords));
    }
}
