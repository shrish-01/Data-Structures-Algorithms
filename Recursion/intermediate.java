import java.util.ArrayList;
import java.util.Arrays;

public class intermediate {
    //    public static ArrayList<Integer> list = new ArrayList<>();
    public static int count = 0;
    public static void main(String[] args) {
        // check if array is sorted
//        int arr[] = {1, 2, 7, 4, 5};
//        int n = arr.length;
//        boolean ans = isSorted(arr, 0, n - 1, n);
//        System.out.println(ans);

        // sum of array:
//        int arr[] = {1, 2, 7, 4, 5};
//        int ans = sumOfArray(arr, 0);
//        System.out.println(ans);

        // check if element is present
//        int arr[] = {1, 2, 3, 4, 5};
//        boolean ans = isElemPresent(7, 0, arr);
//        System.out.println(ans);

        // first index of element
//        int arr[] = {1, 2, 3, 3, 3};
//        int ans = firstIndexOfElement(arr, 0, 3);
//        System.out.println(ans);

        // last index of element
//        int arr[] = {1, 2, 3, 3, 3};
//        int ans = lastIndexOFElement(arr, arr.length - 1, 2);
//        System.out.println(ans);

        // print all position of  element
//        int arr[] = {1, 2, 3, 3, 3};
//        addAllIndexesOfElement(arr, 0, 3);
//        if(list.isEmpty()) {
//            System.out.println("List not populated!");
//        } else {
//            for (Integer integer : list) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }

        // count occurrences of the element
//        int arr[] = {1, 2, 3, 3, 3};
//        countOcccurancesElement(arr, 0, 3);
//        int ans = countOcccurancesElement2(arr, 0, 2);
//        System.out.println(ans);

        // check palindrome
        int arr[] = {1, 2, 3, 7, 2, 1};
        boolean ans = checkPalindrom(arr, 0, arr.length - 1);
        System.out.println(ans);
    }

    private static boolean checkPalindrom(int[] arr, int i, int j) {
        if(i > j) return true;
        if(arr[i] != arr[j]) {
            return false;
        }
        return checkPalindrom(arr, i + 1, j - 1);
    }

//    private static int countOcccurancesElement2(int[] arr, int i, int k) {
//        if(i == arr.length) return 0;
//        if(arr[i] == k) return 1 + countOcccurancesElement(arr, i + 1, k);
//        else return countOcccurancesElement(arr, i + 1, k);
//    }

//    private static void countOcccurancesElement(int[] arr, int i, int k) {
//        if(i == arr.length) return;
//        if(arr[i] == k) count++;
//        countOcccurancesElement(arr, i + 1, k);
//    }

//    private static void addAllIndexesOfElement(int arr[], int i, int k) {
//        if(i == arr.length) return;
//        if(arr[i] == k) list.add(i);
//        addAllIndexesOfElement(arr, i + 1, k);
//    }

    private static int lastIndexOFElement(int[] arr, int i, int k) {
        if(i == 0) return -1;
        if(arr[i] == k) return i;
        return lastIndexOFElement(arr, i - 1, k);
    }

    private static int firstIndexOfElement(int arr[], int i, int k) {
        if(i == arr.length) return -1;
        if(arr[i] == k) return i;
        return firstIndexOfElement(arr, i + 1, k);
    }

    private static boolean isElemPresent(int k, int i, int arr[]) {
        if(i == arr.length) return false;
        if(arr[i] == k) return true;
        return isElemPresent(k, i + 1, arr);
//        return arr[i] == k || isElemPresent(k, i + 1, arr);
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
