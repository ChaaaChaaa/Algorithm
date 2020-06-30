package leetcode;

public class Q344 {
    public static void main(String[] args){

        char [] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        char [] result = new char[s.length];
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i=result.length-1; i>=0; i--){
            result[j++] = s[i];
        }

       for(char element : result){
           System.out.print("\""+element+"\""+",");
       }
    }
}
