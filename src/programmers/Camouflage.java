package programmers;

import java.util.HashMap;

public class Camouflage {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesCategories = new HashMap<>();
        int answer = 1;
        convertArrayToHashMap(clothesCategories, clothes);
        answer = numberOfCombinationCase(clothesCategories, answer);
        return answer;
    }

    private void convertArrayToHashMap(HashMap<String, Integer> clothesCategories, String[][] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            Integer countCloth = clothesCategories.getOrDefault(clothes[i][1], 0);
            clothesCategories.put(clothes[i][1], ++countCloth);
        }
    }

    private int numberOfCombinationCase(HashMap<String, Integer> clothesCategories, int answer) {
        for (String key : clothesCategories.keySet()) {
            answer *= clothesCategories.get(key) + 1;
        }
        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}};


        Camouflage camouflage = new Camouflage();
        System.out.println(camouflage.solution(clothes));
    }
}
