package leetcode;

public class Q1108 {
    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));
    }

//    public static String defangIPaddr(String address) {
//        String replaceAddress = address.replace(".", "[.]");
//        return replaceAddress;
//    }

    public static String defangIPaddr(String address) {
        StringBuffer stringBuffer = new StringBuffer();

        for(int i=0; i<address.length(); i++){
            if(address.charAt(i) == '.'){
                stringBuffer.append("[.]");
            }
            else {
                stringBuffer.append(address.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
