// import java.util.Scanner;

public class one {
    // public static long ans;
    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();

        // int ans = fact(n);
        // System.out.println(ans);

        // nth fibonacci number
        // int ans = fibN(n);
        // System.out.println(ans);

        // power function x to power n
        // int ans = pow(5, 3);
        // System.out.println(ans);

        // print n numbers
        // printNumbers(10);

        // count of digits
        // int ans = counOfDigits(2833382);
        // System.out.println(ans);

        // sum of digits
        // int ans = sumOfDigits(12);
        // System.out.println(ans);

        // Multiplication of two numbers
        // int ans = multiplyNums(4, 7);
        // System.out.println(ans);

        // Count number of zeros
        // countZeros(120002200);
        // System.out.println(ans);

        // Geometric sum, 1 + 1/2 + 1/2^2 + 1/2^2 .... + 1/2^n
        double ans = gsum(2);
        System.out.println(ans);
    }

    private static double gsum(int n) {
        if(n == 0) {
            return 1;
        }
        return gsum(n - 1) + (1 / Math.pow(2, n));
    }

    // private static void countZeros(long n) {
    //     if(n == 0) return;
    //     long lastDigit = n % 10;
    //     if(lastDigit == 0) ans += 1;
    //     countZeros(n/10);
    // }

    private static int multiplyNums(int i, int j) {
        if(j == 0) {
            return 0;
        }
        return multiplyNums(i, j - 1) + i;
    }

    private static int sumOfDigits(int n) {
        if(n == 0) return 0;
        int lastDigit = n % 10;
        return sumOfDigits(n/10) + lastDigit;
    }

    private static int counOfDigits(int n) {
        if(n == 0) return 0;
        return counOfDigits(n/10) + 1;
    }

    private static void printNumbers(int n) {
        if(n == 0) return;
        printNumbers(n - 1);
        System.out.print(n + " ");
    }

    private static int pow(int x, int n) {
        if(n == 0) return 1;
        return x * pow(x, n - 1);
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