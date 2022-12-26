package programmers;

import java.util.HashMap;
import java.util.Map;

public class DidNotFinishRacePlayer {
    public String solution(String[] participate, String[] completion) {
        String answer = "";

        Map<String, Integer> participatePlayerHashMap = new HashMap<>();

        convertHashMap(participate, participatePlayerHashMap);
        checkCompletePlayer(completion, participatePlayerHashMap);

        answer = checkRemainParticipatePlayer(participatePlayerHashMap);

        return answer;
    }

    private Map<String, Integer> convertHashMap(String[] playerList, Map<String, Integer> participatePlayerHashMap) {
        for (String name : playerList) {
            Integer count = participatePlayerHashMap.get(name);

            if (count == null) {
                participatePlayerHashMap.put(name, 1);
                continue;
            }
            participatePlayerHashMap.put(name, ++count);
        }
        return participatePlayerHashMap;
    }

    private Map<String, Integer> checkCompletePlayer(String[] completion,Map<String, Integer> participatePlayerHashMap){
        for(String completePlayer : completion){
            int playerNum = participatePlayerHashMap.get(completePlayer)-1;
            participatePlayerHashMap.put(completePlayer,playerNum);
        }
        return participatePlayerHashMap;
    }

    private String checkRemainParticipatePlayer(Map<String, Integer> participatePlayerHashMap){
        String answer = "";
        for(String remainPlayer : participatePlayerHashMap.keySet()){
            if(participatePlayerHashMap.get(remainPlayer) == 1){
                answer = remainPlayer;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
       // String[] participate = {"leo", "kiki", "eden"};
       // String[] completion = {"eden", "kiki"};

        String [] participate = {"mislav", "stanko", "mislav", "ana"};
        String [] completion = {"stanko", "ana", "mislav"};

        DidNotFinishRacePlayer didNotFinishRacePlayer = new DidNotFinishRacePlayer();
        System.out.println(didNotFinishRacePlayer.solution(participate,completion));
    }
}
