import java.util.concurrent.TimeUnit;
import java.util.*;

public class mergeSort {
    /*
     * We need an extra amount of memory to execute this.
     * This will always take  O(log 'n') since it does the same this at every step
     * */

    /*
     * NB: Rem. we are in 2D not 3D or 4D.
     * 1. Sort the left half.
     * 2. Sort the right half.
     * 3. Merges two sub-arrays of arr[].
     * First sub-array is arr[l..m]
     * Second sub-array is arr[m+1..r]
     *
     * */

    public void merge(int arr[], int l, int m, int r)
    {
        // Find sizes (lengths) of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */
        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {    // If left index is smaller than right index

            // Find the middle point
            int m = (l + r) / 2;

            // Sort first (left) and second (right) halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves by comparing index values and selecting as desired
            // i.e. Upwards or Downwards order.
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Randomise test data
    private static void shuffleArray(int[] array)
    {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // Driver method
    public static void main(String args[]) throws InterruptedException {
        int [] numbers = new int[100];            // Sorted Array of ints 1 - 100000
        for (int a = 0; a < numbers.length; a++) {
            numbers[a] = a + 1;
        }
        shuffleArray(numbers);     // array 2 (Unsorted). This appears too 'manual', maybe we can optimise this..

        long startTime = System.nanoTime();

        System.out.print("Stock : ");
        printArray(numbers);
        mergeSort object = new mergeSort();     // Create a new object to sort our elements
        object.sort(numbers, 0, numbers.length - 1);
        System.out.print("\nSorted : ");
        printArray(numbers);

        TimeUnit.SECONDS.sleep(1);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Merge-sort execution time in nanoseconds: " + timeElapsed);
    }
}

