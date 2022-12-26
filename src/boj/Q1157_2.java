package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q1157_2 {
    private static final int MINVALUE = 0;
    private static final char INIT_KEY = ' ';
    private static final String MULTIPLE_VALUE = "?";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        String changeUpperCase = words.toUpperCase();
        HashMap<Character,Integer> wordsList = new HashMap<>();

        for(int i=0; i<changeUpperCase.length(); i++){
            char word = changeUpperCase.charAt(i);
            Integer wordCount = wordsList.getOrDefault(word,0);
            wordsList.put(word,++wordCount);
        }

        int maxValue = MINVALUE;
        char maxKey = INIT_KEY;
        boolean hasMultipleKey = false;

        for(char key : wordsList.keySet()){
            Integer value = wordsList.get(key);
            if(value>maxValue){
                maxValue = value;
                maxKey = key;
                hasMultipleKey = true;
            }
            else if(value == maxValue){
                hasMultipleKey = false;
            }
        }

        if(hasMultipleKey){
            System.out.println(maxKey);
        }
        else {
            System.out.println(MULTIPLE_VALUE);
        }
    }
}

