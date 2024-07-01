public class intermediate {
    public static void main(String[] args) {
        // check if array is sorted
        int arr[] = {1, 2, 7, 4, 5};
        int n = arr.length;
        boolean ans = isSorted(arr, 0, n - 1, n);
        System.out.println(ans);
    }

    private static boolean isSorted(int[] arr, int i, int j, int n) {
        if(n == 0 || n == 1) return true;
        if(arr[i] > arr[i + 1]) return false;
        return isSorted(arr, i + 1, j, n - 1);
    }
}
