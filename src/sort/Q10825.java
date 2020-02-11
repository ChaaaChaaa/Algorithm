package sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfStudent = Integer.parseInt(br.readLine());

        StringTokenizer st;

        ArrayList<ScoreForStudents> studentReportCard = new ArrayList();

        for (int i = 0; i < numOfStudent; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int koreanScore = Integer.parseInt(st.nextToken());
            int mathScore = Integer.parseInt(st.nextToken());
            int englishScore = Integer.parseInt(st.nextToken());

            studentReportCard.add(new ScoreForStudents(name, koreanScore, englishScore, mathScore));

        }

        FunctionQ10825 function = new FunctionQ10825(studentReportCard);

        function.ComparatorScoreForStudents();
        System.out.print(function.printArr());

    }

}

class FunctionQ10825 {
    private static final String NEW_LINE = "\n";
    private ArrayList<ScoreForStudents> studentReportCard;


    FunctionQ10825(ArrayList studentReportCard) {
        this.studentReportCard = studentReportCard;
    }


    void ComparatorScoreForStudents() {
        Comparator<ScoreForStudents> reverseMath = Comparator.comparing(ScoreForStudents::getMathScore).reversed();

        studentReportCard.sort(Comparator.comparing(ScoreForStudents::getKoreanScore).reversed()
                .thenComparing(ScoreForStudents::getEnglishScore)
                .thenComparing(reverseMath)
                .thenComparing(ScoreForStudents::getName));
    }

    StringBuilder printArr() {
        StringBuilder sb = new StringBuilder();
        for (ScoreForStudents student : studentReportCard) {
            sb.append(student.getName()).append(NEW_LINE);
        }
        return sb;
    }
}


class ScoreForStudents {

    private String name;
    private int koreanScore;
    private int mathScore;
    private int englishScore;

    ScoreForStudents(String name, int koreanScore, int mathScore, int englishScore) {

        this.name = name;
        this.koreanScore = koreanScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    String getName() {
        return name;
    }

    int getKoreanScore() {
        return koreanScore;
    }

    int getMathScore() {
        return mathScore;
    }

    int getEnglishScore() {
        return englishScore;
    }

}



