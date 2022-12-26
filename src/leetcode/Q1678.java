package leetcode;

public class Q1678 {
    public static void main(String[] args){
        String command = "G()()()()(al)";
        System.out.println(interpret(command));
    }

    public static String interpret(String command) {
        String replaceAl = command.replace("(al)","al");
        String replaceO = replaceAl.replace("()","o");
        return replaceO;
    }
}
