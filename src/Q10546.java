import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Q10546 {

    private static final int unCompleteRaceOfParticipant = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int countParticipants = Integer.parseInt(br.readLine());
        String[] participant = new String[countParticipants];
        String[] completion = new String[countParticipants - unCompleteRaceOfParticipant];

        for (int i = 0; i < countParticipants; i++) {
            participant[i] = br.readLine();
        }

        for (int i = 0; i < countParticipants - unCompleteRaceOfParticipant; i++) {
            completion[i] = br.readLine();
        }

        StuffedMarathoner stuffedMarathoner = new StuffedMarathoner(participant, completion);
        stuffedMarathoner.sortMarathoner();
        System.out.println(stuffedMarathoner.printStuffedMarathoner());
    }
}

class StuffedMarathoner {
    private String[] participant;
    private String[] completion;
    private int i;

    StuffedMarathoner(String[] participant, String[] completion) {
        this.participant = participant;
        this.completion = completion;
    }

    void sortMarathoner() {
        Arrays.sort(participant);
        Arrays.sort(completion);
    }

    String printStuffedMarathoner() {
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }

}
