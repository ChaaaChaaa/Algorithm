package programmers;

public class SecretMap2 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] str1 = convertBinary(arr1, n);
        String[] str2 = convertBinary(arr2, n);
        String[] result = new String[arr1.length];

        for (int i = 0; i < str1.length; i++) {
            char[] chars1 = str1[i].toCharArray();
            char[] chars2 = str2[i].toCharArray();
            String temp = "";
            for (int j = 0; j < chars1.length; j++) {
                if (String.valueOf(chars1[j]).equals("1")
                        || String.valueOf(chars2[j]).equals("1")) {
                    temp += ("#");
                } else {
                    temp += (" ");
                }
            }
            result[i] = temp;
        }
        return result;
    }

    public static String[] convertBinary(int[] arr, int n) {
        String[] binaryString = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            StringBuilder sb = new StringBuilder();

            while (temp > 0) {
                sb.append(String.valueOf(temp % 2));
                temp /= 2;
            }
            for (int j = sb.length(); j < n; j++) {
                sb.append(0);
            }
            binaryString[i] = sb.reverse().toString();
        }

        return binaryString;
    }

}
