package boj;

public class Main {
    public static void main(String[] args) throws Exception {

    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] binary1 = binaryCal(arr1, n);
        String[] binary2 = binaryCal(arr2, n);
        String[] binaryKey = new String[arr1.length];

        for (int i = 0; i < binary1.length; i++) {
            char[] ch1 = binary1[i].toCharArray();
            char[] ch2 = binary2[i].toCharArray();
            String temp = "";

            for (int j = 0; j < ch1.length; j++) {
                if (String.valueOf(ch1[j]).equals("1") || String.valueOf(ch2[j]).equals("1")) {
                    temp += "#";
                } else {
                    temp += " ";
                }
            }
            binaryKey[i] = temp;
        }
        return binaryKey;

    }

    public static String[] binaryCal(int[] arr, int n) {
        String[] binaryString = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            StringBuilder binary = new StringBuilder();
            while (temp > 0) {
                binary.append(String.valueOf(temp % 2));
                temp /= 2;
            }
            for (int j = binary.length(); j < n; j++) {
                binary.insert(0,0);
            }
            binaryString[i] = binary.reverse().toString();
        }

        return binaryString;
    }
}