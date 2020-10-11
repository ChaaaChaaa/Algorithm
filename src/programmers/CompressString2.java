package programmers;

public class CompressString2 {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String preString = s.substring(0, 0 + i);
            System.out.println(preString);
            int cnt = 1;
            for (int j = i; j < s.length(); j = j + i) {
                int end = checkLength(i, j, s);
                String tmp = s.substring(j, end);
                System.out.println(tmp);
                if (tmp.equals(preString)) {
                    System.out.println(preString);
                    System.out.println(tmp);
                    cnt++;
                } else {
                    if (cnt == 1) {
                        sb.append(preString);
                    } else {
                        sb.append(cnt);
                        sb.append(preString);
                    }
                    cnt = 1;
                    preString = tmp;
                }
            }
            if (cnt == 1) {
                sb.append(preString);
            } else {
                sb.append(cnt);
                sb.append(preString);
            }
            if (sb.length() < answer) {
                System.out.println(answer);
                int result = sb.length();
                System.out.println(result);
                answer = sb.length();
            }
        }
        return answer;
    }

    private int checkLength(int i, int j, String s) {
        if (j + i < s.length()) {
            return j + i;
        } else
            return s.length();
    }

    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        CompressString2 compressString = new CompressString2();
        int result = compressString.solution(s);
        System.out.println(result);
    }
}
