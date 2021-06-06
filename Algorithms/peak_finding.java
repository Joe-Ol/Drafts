import java.util.Scanner;

public class review {
    public static int find(int array[], int a, int b){
        int mid_index = (a + b) / 2;
        int peak;

        if (array[mid_index] > array[mid_index - 1] & array[mid_index] > array[mid_index + 1]) {
            peak = array[mid_index];

        } else if(array[mid_index - 1] > array[mid_index]) {
            a = a;
            b = mid_index - 1;
            peak = find(array, a, b);

        } else {
            a = mid_index + 1;
            b = b;
            peak = find(array, a, b);
        }

        return peak;
    }


    public static void main(String[] args) {
        int array[] = {12, 34, 20, 10, 18, 23, 89, 27};
        int a = 0;
        int b = array.length - 1;

        System.out.println(find(array, a, b));
    }
}














