import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class ParenthesesChecker {

    public static boolean checkParentheses(String toBeChecked) {
        ArrayList<String> checkList = new ArrayList<>();
        int i = 0;
        while (checkList.size() < toBeChecked.length()) {
            checkList.add(toBeChecked.substring(i,i + 1));
            i++;
        }
        Stack<BracketType> lastStarted = new Stack<>();
        lastStarted.add(BracketType.NONE);
/*        int openParan = 0;
        int closeParan = 0;
        int openSqr = 0;
        int closeSqr = 0;
        int openTriangle = 0;
        int closeTriangle = 0;
        int openBrace = 0;
        int closeBrace = 0;*/
        for (String s : checkList) {
            if (Objects.equals(s, "(")) {
                //openParan++;
                lastStarted.add(BracketType.PARANTHESES);
            } else if (Objects.equals(s, ")")) { if (lastStarted.lastElement() != BracketType.PARANTHESES) {
                return false;
            } else if (lastStarted.lastElement() == BracketType.PARANTHESES) {
                //closeParan++;
                lastStarted.removeElement(BracketType.PARANTHESES);
            } else {
                return false;
            }
            } else if (Objects.equals(s, "[")) {
                //openSqr++;
                lastStarted.add(BracketType.SQUARE);
            } else if (Objects.equals(s, "]")) { if (lastStarted.lastElement() != BracketType.SQUARE) {
                return false;
            } else if (lastStarted.lastElement() == BracketType.SQUARE){
                //closeSqr++;
                lastStarted.removeElement(BracketType.SQUARE);
            } else {
                return false;
            }
            } else if (Objects.equals(s,"<")) {
                //openTriangle++;
                lastStarted.add(BracketType.TRIANGLE);
            } else if (Objects.equals(s,">")) { if (lastStarted.lastElement() != BracketType.TRIANGLE) {
                return false;
            } else if (lastStarted.lastElement() == BracketType.TRIANGLE){
                //closeTriangle++;
                lastStarted.removeElement(BracketType.TRIANGLE);
            } else {
                return false;
            }
            } else if (Objects.equals(s,"{")) {
                //openBrace++;
                lastStarted.add(BracketType.BRACE);
            }  else if (Objects.equals(s,"}")) {if (lastStarted.lastElement() != BracketType.BRACE) {
                return false;
            } else if (lastStarted.lastElement() == BracketType.BRACE){
                //closeBrace++;
                lastStarted.removeElement(BracketType.BRACE);
            } else {
                return false;
            }
            }
/*            if (closeParan > openParan || closeSqr > openSqr || closeTriangle > openTriangle || closeBrace > openBrace) {
                return false;
            }*/
        }
        return lastStarted.lastElement() == BracketType.NONE;
        //return closeParan == openParan && closeSqr == openSqr && closeTriangle == openTriangle && closeBrace == openBrace;
    }


}
