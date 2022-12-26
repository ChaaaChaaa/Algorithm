package leetcode;

public class Q13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("LM"));
        System.out.println("gy ");
    }

    public static int romanToInt(String s) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;

        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1])
                sum -= a[i];
            else
                sum += a[i];
        }
        return sum + a[a.length - 1];
    }
}
