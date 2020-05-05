package programmers;


class DartGame {
    int solution(String dartResult) {
        char[] charArray = dartResult.toCharArray();
        int i = 0;
        int[] scores = new int[3];
        StringBuilder sb = new StringBuilder();
        for (char ch : charArray) {
            switch (ch) {
                case 'S':
                    scores[i++] = Integer.parseInt(sb.toString());
                    sb.setLength(0);
                    break;
                case 'D':
                    int a = Integer.parseInt(sb.toString());
                    scores[i++] = a * a;
                    sb.setLength(0);
                    break;
                case 'T':
                    int b = Integer.parseInt(sb.toString());
                    scores[i++] = b * b * b;
                    sb.setLength(0);
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
