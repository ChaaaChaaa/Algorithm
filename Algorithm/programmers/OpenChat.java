package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChat {
    private static final String BLANK = " ";
    private static final String ENTER = "Enter";
    private static final String CHANGE = "Change";
    private static final String LEAVE = "Leave";
    private static final int INSTRUCTION = 0;
    private static final int NICKNAME = 2;
    private static final int USER_ID = 1;


    public String[] solution(String[] record) {
        HashMap<String, String> hashmap = new HashMap<>();
        ArrayList<String> resultList = new ArrayList<>();

        for (String s : record) {
            String[] array = s.split(BLANK);
            if (array[INSTRUCTION].equals(ENTER) || array[INSTRUCTION].equals(CHANGE)) {
                hashmap.put(array[USER_ID], array[NICKNAME]);
            }
        }

        for (String s : record) {
            String[] array = s.split(BLANK);
            if (!array[INSTRUCTION].equals(CHANGE)) {
                String tempS = makeWord(array, hashmap);
                resultList.add(tempS);
            }
        }

        String[] answer = resultList.toArray(new String[resultList.size()]);
        return answer;
    }

    private String makeWord(String[] arr, HashMap hashmap) {
        String tempS = hashmap.get(arr[USER_ID]) + "님이 ";
        if (arr[INSTRUCTION].equals(ENTER)) {
            tempS += "들어왔습니다.";
        } else if (arr[INSTRUCTION].equals(LEAVE)) {
            tempS += "나갔습니다.";
        }
        return tempS;
    }

    public static void main(String[] args) {
        String[] s = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        OpenChat openChat = new OpenChat();
        for (String element : openChat.solution(s)) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
