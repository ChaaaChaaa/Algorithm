package programmers;

import java.util.ArrayList;
import java.util.List;


public class TakeAPicture {
    private static final String [] kakaoFriends = {"A", "C", "F", "J", "M", "N", "R", "T"};


    public int solution(int n, String [] data){
        int answer = 0;
        List<String> answerArray = new ArrayList<>();
        boolean [] visited = new boolean[kakaoFriends.length];
        dfs(0,kakaoFriends.length,visited,"",answerArray);
        for(int i=0; i<answerArray.size(); i++){
            if(conditionCheck(n,data,answerArray.get(i))){
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int current, int end, boolean[] visited, String answer,List<String> answerArray){
        if(current == end){
            answerArray.add(answer);
        }

        for(int i=0; i<kakaoFriends.length; i++){
            if(!visited[i]){
                visited[i] = true;
                answer+= kakaoFriends[i];
                dfs(current+1,end,visited,answer,answerArray);
                visited[i] = false;
                int size = answer.length()-1;
                answer = answer.substring(0,size);
            }
        }
    }

    private boolean conditionCheck(int n, String[] data, String friendsOrder){
        for(int i=0; i<data.length; i++){
            String first = String.valueOf(data[i].charAt(0));
            String second = String.valueOf(data[i].charAt(2));
            String comparator = String.valueOf(data[i].charAt(3));
            int comparatorNum = Integer.parseInt(String.valueOf(data[i].charAt(4)));


            int firstIdx = friendsOrder.indexOf(first);
            int secondIdx = friendsOrder.indexOf(second);

            if(comparator.equals(">")){
                if(Math.abs(firstIdx - secondIdx) <= comparatorNum+1){
                    return false;
                }
            }

            else if(comparator.equals("<")){
                if(Math.abs(firstIdx - secondIdx) >= comparatorNum+1){
                    return false;
                }
            }

            else {
                if(Math.abs(firstIdx - secondIdx) != comparatorNum+1){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args){

        TakeAPicture takeAPicture = new TakeAPicture();
        String [] data = {"N~F=0", "R~T>2"};
        int n = 2;
        int result = takeAPicture.solution(n,data);
        System.out.println(result);

    }
}
