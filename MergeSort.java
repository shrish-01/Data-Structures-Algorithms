import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int mid = (i + j) / 2;
        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    private static void merge(int[] arr, int i, int mid, int j) {
        int secondStart = mid + 1, originalStartIndex = i;
        int mix[] = new int[j - i + 1];
        int k = 0;

        while (i <= mid && secondStart <= j) {
            if (arr[i] < arr[secondStart]) {
                mix[k] = arr[i];
                i++;
            } else {
                    mix[k] = arr[secondStart];
                secondStart++;
            }
            k++;
        }

        while (i <= mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (secondStart <= j) {
            mix[k] = arr[secondStart];
            secondStart++;
            k++;
        }

        System.arraycopy(mix, 0, arr, originalStartIndex, mix.length);
    }

    // public static int[] mergeSort(int arr[]) {

    // if(arr.length == 1) {
    // return arr;
    // }

    // int mid = arr.length / 2;
    // int left[] = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    // int right[] = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

    // return merge(left, right);
    // }

    // private static int[] merge(int[] left, int[] right) {
    // int i = 0, j = 0, k = 0;
    // int mix[] = new int[left.length + right.length];

    // while(i < left.length && j < right.length) {
    // if(left[i] < right[j]) {
    // mix[k] = left[i];
    // i++;
    // } else {
    // mix[k] = right[j];
    // j++;
    // }
    // k++;
    // }

    // while(i < left.length) {
    // mix[k] = left[i];
    // i++;
    // k++;
    // }

    // while(j < right.length) {
    // mix[k] = right[j];
    // j++;
    // k++;
    // }

    // return mix;
    // }

}
