//import java.util.Arrays;

public class advanced {

//    public static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        // recursively print a character array
//        char[] arr = {'a', 'b', 'c', 'd', 'e'};
//        printCharArr(arr, 0);
////        printCharArrReverse(arr, arr.length - 1);
//        System.out.println();

        // replace character in a string
//        String str = "abcabcabc";
//        char[] arr = str.toCharArray();
//        replaceChars(arr, 'a', 'x', 0);
//        StringBuilder updatedStr = new StringBuilder();
//        for(char ch: arr) {
//            updatedStr.append(ch);
//        }
//        System.out.println(updatedStr);

        // remove consecutive duplicates
//        StringBuilder str = new StringBuilder("aaabbbccccccccccccdda"); // expecting an output: "abcda"
////        for(int i = 0; i < str.length(); i++) {
////            if(i == 1) {
////                str.deleteCharAt(i);
////            }
////        }
////        System.out.println(str);
//        deleteConsecutiveDuplicates(str, 1, str.charAt(0));
//        System.out.println(str);

        // print subsequences of a string
//        printSubsequences("abc", "", 0);

        // store all subsequences of string
//        storeSubsequences("abc", "", 0);
////        System.out.println(ans.size());
//        for(String str: ans) {
//            System.out.print(str + ", ");
//        }

        // convert string to int
//        String str = "12345";
//        int num = convertStringToInt(str, str.length() - 1, 0);
//        System.out.println(num);

        // print all permutations of a string
//        printPermutations("abc", 0); // abc, acb, bac, bca, cab, cba

        // climb stairs
//        int ans = climbStairs(5);
//        System.out.println(ans);

        // tower of hanoi
//        int ans = towerOfHanoi(5);
//        System.out.println(ans);

//        towerOfHanoiPrintSteps(3, 'a', 'b', 'c');
    }

    private static void towerOfHanoiPrintSteps(int n, char a, char b, char c) {
        if(n == 0) return;
        towerOfHanoiPrintSteps(n - 1, 'a', 'c', 'b');
        System.out.println("Disc " + n + " is moved from tower " + a + " to " + b + ".");
        towerOfHanoiPrintSteps(n - 1, 'c', 'b', 'a');
    }

    private static int towerOfHanoi(int n) {
        if(n <= 0) {
            return 0;
        }

        return towerOfHanoi(n - 1) + 1 + towerOfHanoi(n - 1);
    }

    private static int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;
        if(n < 0) return 0;
        return climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
    }

    private static void printPermutations(String str, int i) {
        if(i == str.length()) {
            System.out.println(str);
            return;
        }
        for(int j = i; j < str.length(); j++) {
            String strEdited = swap(str, i, j);
            printPermutations(strEdited, i + 1);
            String strReverseEdited = swap(str, i, j);
        }
    }

    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);

        return sb.toString();
    }

    private static int convertStringToInt(String str, int i, int currNum) {
        if(i < 0) return currNum;
        return convertStringToInt(str, i - 1, (currNum + (str.charAt(i) - '0') * (int)Math.pow(10, str.length() - 1 - i)));
    }

//    private static void storeSubsequences(String str, String currStr, int i) {
//        if(i == str.length()) {
//            ans.add(currStr);
//            return;
//        }
//
//        // not pick
//        storeSubsequences(str, currStr, i + 1);
//        // pick
//        storeSubsequences(str, currStr+str.charAt(i), i + 1);
//    }

    private static void printSubsequences(String str, String currStr, int i) {
        if(i == str.length()) {
            if(currStr.isEmpty()) {
                System.out.println("''");
            } else {
                System.out.println(currStr);
            }
            return;
        }

        // not pick
        printSubsequences(str, currStr, i + 1);
        // pick
        printSubsequences(str, currStr+str.charAt(i), i + 1);
    }

    private static void deleteConsecutiveDuplicates(StringBuilder str, int i, char prev) {
        if(i == str.length()) {
            return;
        }
        if(str.charAt(i) == prev) {
            str.deleteCharAt(i);
            deleteConsecutiveDuplicates(str, i, prev);
        } else {
            deleteConsecutiveDuplicates(str, i + 1, str.charAt(i));
        }
    }

    private static void replaceChars(char[] arr, char a, char x, int i) {
        if(i == arr.length) return;

        if(arr[i] == a) {
            arr[i] = x;
        }

        replaceChars(arr, a, x, i + 1);
    }

    private static void printCharArrReverse(char[] arr, int n) {
        if(n < 0) return;
        System.out.print(arr[n] + ", ");
        printCharArrReverse(arr, n - 1);
    }

    private static void printCharArr(char[] arr, int i) {
        if(i == arr.length) {
            return;
        }
        if(i == arr.length - 1) {
            System.out.print(arr[i]);
        } else {
            System.out.print(arr[i] + ", ");
        }
        printCharArr(arr, i + 1);
        // for reverse this is also a method.
//        System.out.print(arr[i] + ", ");
    }
}

// GFG Code:
//class Hanoi {
//
//    public long count = 0;
//
//    public long toh(int n, int from, int to, int aux) {
//        // Your code here
//        tohH(n, from, to, aux);
//        return count;
//    }
//
//    public void tohH(int n, int from, int to, int aux) {
//        // Your code here
//        if(n == 0) return;
//        tohH(n - 1, from, aux, to);
//        count++;
//        System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
//        tohH(n - 1, aux, to, from);
//    }
//}
