import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int ans = fact(n);
        // System.out.println(ans);

        // nth fibonacci number
        int ans = fibN(n);
        System.out.println(ans);
    }

    private static int fibN(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2 || n == 3) {
            return 1;
        }

        return fibN(n - 1) + fibN(n - 2);
    }

    private static int fact(int n) {
        if(n == 0) {
            return 1;
        }
        int smallAns = fact(n - 1);
        return n * smallAns;
    }
}