//import java.util.Arrays;

public class advanced {
    public static void main(String[] args) {
        // recursively print a character array
//        char[] arr = {'a', 'b', 'c', 'd', 'e'};
//        printCharArr(arr, 0);
////        printCharArrReverse(arr, arr.length - 1);
//        System.out.println();

        // replace character in a string
        String str = "abcabcabc";
        char[] arr = str.toCharArray();
        replaceChars(arr, 'a', 'x', 0);
        StringBuilder updatedStr = new StringBuilder();
        for(char ch: arr) {
            updatedStr.append(ch);
        }
        System.out.println(updatedStr);
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