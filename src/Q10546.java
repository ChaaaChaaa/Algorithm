import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Q10546 {

    private static final int unCompleteRaceOfParticipant = 1;

    public static void main(String[] args) throws IOException {
        StuffedMarathoner stuffedMarathoner = new StuffedMarathoner();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int countParticipants = Integer.parseInt(br.readLine());

        String[] participant = new String[countParticipants];
        String[] completion = new String[countParticipants - unCompleteRaceOfParticipant];

        for (int i = 0; i < countParticipants; i++) {
            participant[i] = br.readLine();
            stuffedMarathoner.getForEachParticipate(participant);
        }

        for (int i = 0; i < countParticipants - unCompleteRaceOfParticipant; i++) {
            completion[i] = br.readLine();
            stuffedMarathoner.getForEachCompletion(completion);
        }

        String name = stuffedMarathoner.printStuffedMarathoner(completion);
        System.out.println(name);
    }
}

class StuffedMarathoner {
    private static final int baseNumOfParticipant = 1;
    private static final int whoCompleteRace = 1;

    private String stuffedParticipant;
    private Map<String, Integer> mapOfParticipants = new HashMap<>();

    void getForEachParticipate(String[] participant) {
        for (String marathoner : participant) {
            countParticipate(marathoner);
        }
    }

    private void countParticipate(String marathoner) {
        if (flagContainsName(marathoner)) {
            int countOfMarathoner = mapOfParticipants.get(marathoner);
            mapOfParticipants.put(marathoner, baseNumOfParticipant + countOfMarathoner);
        }
        if (!flagContainsName(marathoner)) {
            mapOfParticipants.put(marathoner, baseNumOfParticipant);
        }
    }

    private boolean flagContainsName(String marathoner) {
        return mapOfParticipants.containsKey(marathoner);
    }

    void getForEachCompletion(String[] completion) {
        for (String marathoner : completion) {
            countCompletion(marathoner);
        }
    }

    private void countCompletion(String marathoner) {
        int countOfMarathoner = mapOfParticipants.get(marathoner);
        mapOfParticipants.put(marathoner, countOfMarathoner - whoCompleteRace);
    }

    String printStuffedMarathoner(String[] completion) {
        for (String marathoner : completion) {
            findStuffedParticipant(marathoner);
        }
        return stuffedParticipant;
    }

    private void findStuffedParticipant(String marathoner) {
        if (mapOfParticipants.get(marathoner) != 0) {
            stuffedParticipant = marathoner;
        }

    }
}
