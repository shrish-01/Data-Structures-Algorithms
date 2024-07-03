import java.util.ArrayList;
import java.util.Arrays;

public class intermediate {
    public static void main(String[] args) {
        // check if array is sorted
//        int arr[] = {1, 2, 7, 4, 5};
//        int n = arr.length;
//        boolean ans = isSorted(arr, 0, n - 1, n);
//        System.out.println(ans);

        // sum of array:
        int arr[] = {1, 2, 7, 4, 5};
        int ans = sumOfArray(arr, 0);
        System.out.println(ans);
    }

    private static int sumOfArray(int[] arr, int i) {
        if(i == arr.length) {
            return 0;
        }
        return sumOfArray(arr, i + 1) + arr[i];
    }

    private static boolean isSorted(int[] arr, int i, int j, int n) {
        if(n == 0 || n == 1) return true;
        if(arr[i] > arr[i + 1]) return false;
        return isSorted(arr, i + 1, j, n - 1);
    }
}
