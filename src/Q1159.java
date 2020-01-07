import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Q1159 {

    public static void main(String[] args) throws IOException {

        BaseballMatch baseballMatch = new BaseballMatch();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countPlayers = Integer.parseInt(br.readLine());

        for (int i = 0; i < countPlayers; i++) {
            String nameOfPlayer = br.readLine();

            baseballMatch.splitFirstLetterFromPlayerName(nameOfPlayer);
            baseballMatch.countFirstLetterFromPlayerName();
        }

        baseballMatch.forEachGetFirstLetter();
        String firstLetterOfSelectedPlayerName = baseballMatch.print5PlayersWhoHaveSameFirstLetter();
        System.out.println(firstLetterOfSelectedPlayerName);
    }
}

class BaseballMatch {
    private static final int firstLetterIndex = 0;
    private static final int baseNumPlayer = 1;
    private static final int selectedPlayersNum = 5;
    private static final String surrender = "PREDAJA";

    private Map<Character, Integer> mapOfPlayersName = new HashMap<>();

    private char firstLetterOfName;
    private String selectedPlayer = "";


    void splitFirstLetterFromPlayerName(String nameOfPlayer) {
        firstLetterOfName = nameOfPlayer.charAt(firstLetterIndex);
    }

    void countFirstLetterFromPlayerName() {
        if (flagContainsFirstLetter(firstLetterOfName)) {
            int countPlayer = mapOfPlayersName.get(firstLetterOfName);
            mapOfPlayersName.put(firstLetterOfName, baseNumPlayer + countPlayer);
        }

        if (!flagContainsFirstLetter(firstLetterOfName)) {
            mapOfPlayersName.put(firstLetterOfName, baseNumPlayer);
        }
    }

    private boolean flagContainsFirstLetter(char firstLetterOfName) {
        return mapOfPlayersName.containsKey(firstLetterOfName);
    }

    void forEachGetFirstLetter() {
        for (char selectedPlayerTmpKey : mapOfPlayersName.keySet()) {
            int selectedPlayerTmpValue = mapOfPlayersName.get(selectedPlayerTmpKey);
            select5PlayersWhoHaveSameFirstLetter(selectedPlayerTmpKey, selectedPlayerTmpValue);
        }
    }

    private void select5PlayersWhoHaveSameFirstLetter(char selectedPlayerTmpKey , int selectedPlayerTmpValue ) {
        if (selectedPlayerTmpValue >= selectedPlayersNum) {
            selectedPlayer += selectedPlayerTmpKey;
        }
    }

    String print5PlayersWhoHaveSameFirstLetter() {
        if ("".equals(selectedPlayer)) {
            return surrender;
        }
        return selectedPlayer;
    }
}
