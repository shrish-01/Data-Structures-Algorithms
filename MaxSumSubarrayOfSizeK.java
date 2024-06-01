import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int k = 3, n = arr.size();
        long ans = maximumSumSubarray(k, arr, n);
        System.out.println(ans);
    }

    private static long maximumSumSubarray(int k, ArrayList<Integer> arr, int n) {
        long maxi = Integer.MIN_VALUE, runningSum = 0;
        int i = 0, j = 0;
        while(j < n) {
            runningSum += arr.get(j);
            if(j - i + 1 == k) {
                maxi = Math.max(maxi, runningSum);
                runningSum -= arr.get(i);
                i++;
            }
            j++;
        }
        return maxi;
    }
}
