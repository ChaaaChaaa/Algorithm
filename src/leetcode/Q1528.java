package leetcode;

public class Q1528 {
    public static void main(String[] args){
        String s = "codeleet";
        int [] indices = {4,5,6,7,0,2,1,3};
        System.out.println( restoreString(s,indices));
    }


    public static String restoreString(String s, int[] indices) {
       char [] word = new char[indices.length];
       for(int i=0; i<indices.length; i++){
           word[indices[i]] = s.charAt(i);
       }
       return new String(word);
    }
}
