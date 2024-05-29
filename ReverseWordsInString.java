public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "the sky is blue";
        String s = str.trim();
        StringBuilder sb = new StringBuilder();

        int prevSpace = s.length();
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if(ch == ' ') {
                sb.append(s.substring(i + 1, prevSpace));
                sb.append(' ');
                while(i >= 0 && s.charAt(i) == ' ') {
                    i--;
                }
                prevSpace = i + 1;
            }
        }

        sb.append(s.substring(0, prevSpace));

        System.out.println(sb.toString());
    }
}
