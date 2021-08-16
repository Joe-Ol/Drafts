import java.util.Random;
import java.util.concurrent.TimeUnit;

public class bubbleSort {
    public static void sort(int[] array) {
        boolean sort_Complete = false;
        // int last = array.length-1;
        while (!sort_Complete) {
            sort_Complete = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]){
                    swapOrder(array, i, i+1);
                    sort_Complete = false;
                }
            }
            // last--;
        }
    }

    public static void swapOrder(int[] array, int x, int y) {
        double temp = array[x];
        array[x] = array[y];
        array[y] = (int) temp;
    }

    /* A utility function to print array of size n */
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

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

    public static void main(String[] args) throws InterruptedException {

        int [] numbers = new int[100000];                       // Sorted Array of 100000
        for (int a = 0; a < numbers.length; a++) {
            numbers[a] = a + 1;
        }
        shuffleArray(numbers);

        long startTime = System.nanoTime();

        System.out.print("Stock : ");
        printArray(numbers);
        sort(numbers);
        System.out.print("\nSorted : ");
        printArray(numbers);

        TimeUnit.SECONDS.sleep(1);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("\nExecution time in nanoseconds: " + timeElapsed);

    }
}
