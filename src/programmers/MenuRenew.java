package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MenuRenew {
    public static void main(String[] args) {
        String o[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int c[] = {2, 3, 4};

        System.out.println(Arrays.toString(solution(o, c)));
    }

    static HashMap<String, Integer> menuMap = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> before = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String menu : orders) {
            char[] temp = menu.toCharArray();
            Arrays.sort(temp);
            for (int i : course) {
                combinationMenu(temp, sb, 0, 0, i);
            }
        }

        for (int i : course) {
            Set<Map.Entry<String, Integer>> copyMenuMap = menuMap.entrySet();

            int max = 0;
            for(Map.Entry<String,Integer> entry : copyMenuMap){
                if(entry.getKey().length() == i){
                    max = Math.max(max,entry.getValue());
                }
            }

            for(Map.Entry<String,Integer> entry : copyMenuMap){
                if(max>1 && entry.getValue() == max && entry.getKey().length()==i){
                    before.add(entry.getKey());
                }
            }
        }

        Collections.sort(before);
        String [] answer = new String[before.size()];

        for(int i=0; i<before.size(); i++){
            answer[i] = before.get(i);
        }

        return answer;
    }

    private static void combinationMenu(char [] order, StringBuilder sb, int start, int depth, int r) {
        if(depth==r){
            menuMap.put(sb.toString(),menuMap.getOrDefault(sb.toString(),0)+1);
            return;
        }
        for(int i=start; i<order.length; i++){
            sb.append(order[i]);
            combinationMenu(order,sb,i+1,depth+1,r);
            sb.delete(depth,depth+1);
        }
    }

}
