package programmers;

import java.util.HashMap;

public class ListOfPhoneNumber {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> phoneHashMap = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            phoneHashMap.put(phone_book[i], "prefix");
        }

        for (String phone_number : phone_book) {
            answer = isContainPhoneNumber(phone_number,phoneHashMap,answer);
        }

        return answer;
    }

    public boolean isContainPhoneNumber(String phone_number,HashMap<String, String> phoneHashMap,boolean answer ){
        for (int idx = 1; idx < phone_number.length(); idx++) {
            if (phoneHashMap.containsKey(phone_number.substring(0, idx))) {
               System.out.println(phone_number.substring(0, idx));
               answer = false;
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args){
       String [] phone_book = {"119", "97674223", "1195524421"};
        ListOfPhoneNumber listOfPhoneNumber = new ListOfPhoneNumber();
        System.out.println("333"+listOfPhoneNumber.solution(phone_book));

    }
}
