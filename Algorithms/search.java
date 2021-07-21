//
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Search {

    public static boolean binarySearch(int[] array, int x, int left, int right) {
        if (left>right) {
            return false;
        }

        // int midpoint = left + ((right - left) / 2);
        int midpoint = (left + right ) / 2;

        if (array[midpoint] == x) {
            return true;
        } else if (x < array[midpoint]) {
            return binarySearch(array, x, left, midpoint - 1);
        } else {
            return binarySearch(array, x, midpoint + 1 , right);
        }
    }

    public static boolean linearSearch(int [] array, int x){
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                return true;
            }
        } return false;
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
        int[] lamp_heights = {1,2,3,4,7,8,9};
        int[] lamp_heights_two = {3,4,2,18,7,8,1,9};

        /*int [] nums = new int[100];
        for (int a = 0; a < nums.length; a++) {
            nums[a] = a + 1;
        }
        shuffleArray(nums);

        long startTime = System.nanoTime();

        if (binarySearch(nums, 90, 0, nums.length-1)){
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        TimeUnit.SECONDS.sleep(5);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("\nExecution time in nanoseconds: " + timeElapsed);*/

        System.out.println(linearSearch(lamp_heights_two, 7));
    }

}
