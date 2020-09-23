package programmers;

public class Q1 {
    public String solution(String new_id){
        String match = "[^0-9a-z_.-]";
        String convertSmallCharacter = new_id.toLowerCase().replaceAll(match,"");
        String convertDoubleDot = convertSmallCharacter.replaceAll("\\.+",".");
        String removeDot = isContainDotFirstAndLast(convertDoubleDot);
        String removeBlankString = isBlank(removeDot);
        String removeMaxString = checkMax(removeBlankString);
        String addMinString = checkMin(removeMaxString);
        String answer = addMinString;
        return answer;
    }

    private String isContainDotFirstAndLast(String id){
        if(id.charAt(0) == '.'){
            id = id.replaceFirst(".","");
        }

        int index =id.length();
        if(index > 0 && id.charAt(index-1) == '.'){
            id = id.substring(0,index-1);
        }
        else {
            return id;
        }
        return id;
    }

    private String isBlank(String id){
        if(id.isEmpty()){
           id = "a";
        }
        return id;
    }

    private String checkMax(String id){
        if(id.length()>=16){
            id = id.substring(0,15);
        }
        int index =id.length();
        if(index > 0 && id.charAt(index-1) == '.'){
            id = id.substring(0,index-1);
        }
        return id;
    }

    private String checkMin(String id){
        int index =id.length();
        for(int i=0; i<3; i++){
            if(id.length()<=2){
                id = id+id.charAt(index-1);
            }
        }
        return id;
    }




    public static void main(String[] args){
      String test = "...!@bat#*..y.abcdefghijklm.";
      //  String test = "=.=";
        Q1 q1 = new Q1();
        System.out.println(q1.solution(test));
    }
}
