package programmers;

public class CompressString {
    public int solution(String s) {
        String exStr = s;
        String bufStr = "";
        int bufCount = 1;
        int resultLen = exStr.length();
        int resultCount = resultLen;

        for(int i = 1 ; i <= exStr.length()/2; i++) {
            int result = exStr.length()/2;
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 1 ; j <= exStr.length()/i; j++) {
                int result2 = exStr.length()/i;
                if (bufStr.equals(resultSubString(exStr, i, j))) {
                    System.out.println(resultSubString(exStr, i, j));
                    bufCount++;
                }else {
                    if(bufCount != 1) {
                        stringBuilder.append(bufCount);
                        bufCount = 1;
                    }
                    String unitWord = resultSubString(exStr, i, j);
                    stringBuilder.append(unitWord);
                }
                bufStr = resultSubString(exStr, i, j);
            }
            if(bufCount != 1) {
                stringBuilder.append(bufCount);
                bufCount = 1;
            }
            if (resultLen % i != 0) {
                String everyResult = exStr.substring(resultLen - resultLen % i, resultLen);
                stringBuilder.append(everyResult);

            }

            if (stringBuilder.length() < resultCount) {
                resultCount = stringBuilder.length();
            }
        }
        return resultCount;
    }

    private String resultSubString(String exStr, int i, int j) {
        String result = exStr.substring((j - 1) * i, j * i);
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        CompressString compressString = new CompressString();
        int result = compressString.solution(s);
        System.out.println(result);
    }
}
