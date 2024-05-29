import java.util.Scanner;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String newStr = removeOutermostParentheses(str);
        System.out.println(newStr);
        scn.close();
    }

    private static String removeOutermostParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0, prev = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                open++;
            } else if(s.charAt(i) == ')') {
                open--;
                if(open == 0) {
                    sb.append(s.substring(prev + 1, i));
                    prev = i + 1;
                }
            }
        }
        return sb.toString();
    }
}