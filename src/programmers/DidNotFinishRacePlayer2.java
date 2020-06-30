package programmers;

import java.util.HashMap;

public class DidNotFinishRacePlayer2 {
    public String solution(String[] participate, String[] completion) {
        String answer = "";

        HashMap<String, Integer> remainPlayers = new HashMap<>();

        for (String participatePlayer : participate) {
//            Integer countPlayer = remainPlayers.get(participatePlayer);
//            if (countPlayer == null) {
//                remainPlayers.put(participatePlayer, 1);
//                continue;
//            }

            Integer countPlayer = remainPlayers.getOrDefault(participatePlayer,0);
            remainPlayers.put(participatePlayer, ++countPlayer);
        }


        for (String completePlayer : completion) {
            Integer removePlayerNum = remainPlayers.get(completePlayer);
            remainPlayers.put(completePlayer, --removePlayerNum);
        }

        for (String remainPlayer : remainPlayers.keySet()) {
            if (remainPlayers.get(remainPlayer) == 1) {
                answer = remainPlayer;
            }
        }

        return answer;
    }

}
