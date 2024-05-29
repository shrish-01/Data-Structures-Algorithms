public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int arr[] = {4, 5, 1, 2, 3};
        System.out.println(check(arr));
    }

    private static boolean check(int[] arr) {
        int n = arr.length;
        int cntr = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > arr[(i + 1) % n]) {
                cntr++;
            }
            if(cntr > 1) {
                return false;
            }
        }
        return true;
    }
}