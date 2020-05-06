package programmers;


class DartGame {
    private static final int RESET_SB = 0;
    private static final int SCORE_LENGTH = 3;

    int solution(String dartResult) {
        char[] dartResultCharArray = dartResult.toCharArray();
        int i = 0;
        int[] scores = new int[SCORE_LENGTH];
        StringBuilder sb = new StringBuilder();
        for (char ch : dartResultCharArray) {
            switch (ch) {
                case 'S':
                    scores[i++] = Integer.parseInt(sb.toString());
                    sb.setLength(RESET_SB);
                    break;
                case 'D':
                    int scoreToCheckDouble = Integer.parseInt(sb.toString());
                    scores[i++] = scoreToCheckDouble * scoreToCheckDouble;
                    sb.setLength(RESET_SB);
                    break;
                case 'T':
                    int scoreToCheckTriple = Integer.parseInt(sb.toString());
                    scores[i++] = scoreToCheckTriple * scoreToCheckTriple * scoreToCheckTriple;
                    sb.setLength(RESET_SB);
                    break;
                case '*':
                    if (i > 1) {
                        scores[i - 2] = scores[i - 2] * 2;
                    }
                    scores[i - 1] = scores[i - 1] * 2;
                    break;

                case '#':
                    scores[i - 1] = scores[i - 1] * -1;
                    break;
                default:
                    sb.append(ch);
                    break;
            }
        }

        int answer = scores[0] + scores[1] + scores[2];
        return answer;
    }
}
