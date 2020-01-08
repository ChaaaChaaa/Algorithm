import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Q1157 {
    public static void main(String[] args) throws IOException {
        StudyWord studyWord;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        studyWord = new StudyWord(word);


        studyWord.inputSplitLetterFromUppercase();
        String letter = studyWord.countEachLetterInMap();

        System.out.println(letter);
    }
}

class StudyWord {
    private static final int baseNumOfLetter = 1;
    private static final String notOneTheMostLetter = "?";

    private String word;
    private char splitLetterFromWord;
    private int iterEachLetterCountValue = 0;
    private int theMostUsedLetterValue = 0;
    private String theMostUsedLetterKey;

    private Map<Character, Integer> mapOfLetter = new HashMap<>();

    StudyWord(String word) {

        this.word = word;
    }

    void inputSplitLetterFromUppercase() {
        for (int i = 0; i < word.length(); i++) {
            String changeUppercase = word.replaceAll("[^a-zA-Z]", "").toUpperCase();
            splitLetterFromWord = changeUppercase.charAt(i);
            inputEachLetterInMap();
        }
    }

    private void inputEachLetterInMap() {

        if (flagContainLetter(splitLetterFromWord)) {
            int num = mapOfLetter.get(splitLetterFromWord);
            mapOfLetter.put(splitLetterFromWord, baseNumOfLetter + num);
        }
        if (!flagContainLetter(splitLetterFromWord)) {
            mapOfLetter.put(splitLetterFromWord, baseNumOfLetter);
        }
    }

    private boolean flagContainLetter(char splitUppercaseWord) {

        return mapOfLetter.containsKey(splitUppercaseWord);
    }

    String countEachLetterInMap() {
        for (char tmpEachLetterKey : mapOfLetter.keySet()) {
            iterEachLetterCountValue = mapOfLetter.get(tmpEachLetterKey);
            findTheMostUsedLetter(tmpEachLetterKey);
        }
        return theMostUsedLetterKey;
    }

    private void findTheMostUsedLetter(char tmpEachLetterKey) {
        if (iterEachLetterCountValue > theMostUsedLetterValue) {
            theMostUsedLetterValue = iterEachLetterCountValue;
            theMostUsedLetterKey = Character.toString(tmpEachLetterKey);
        }
        else{
            theMostUsedLetterKey = notOneTheMostLetter;
        }
    }
}
