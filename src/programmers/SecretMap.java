package programmers;

public class SecretMap {
    private static final char WALL_Binary = '1';
    private static final char WALL_PRINT = '#';
    private static final String BLANK =" ";
    private static final String initResult ="";

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String [] answer = new String[n];

        for(int i=0; i<n; i++){
            int num = arr1[i] | arr2[i];
            String convertBinary = Integer.toBinaryString(num);
            String rowResult = initResult;

            for(int k=0; k<convertBinary.length(); k++){
                if (convertBinary.charAt(k) == WALL_Binary) {
                    rowResult+=WALL_PRINT;
                }
                else {
                    rowResult += BLANK;
                }
            }

            for(int l =0; l<n-convertBinary.length(); l++){
                rowResult= BLANK+rowResult;
            }

            System.out.println(rowResult);
            answer[i] = rowResult;
        }
        return answer;
    }
}


