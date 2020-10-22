public class heapSort {
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void buildMaxHeap(int arr[]) {
        int size = arr.length;
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(arr, size, i);//
    }
    public void heapify(int[] arr, int size, int root) {

        int max = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;


        if (left < size)
            if (arr[left] > arr[max]) {
                max = left;
            }

        if (right < size)
            if (arr[right] > arr[max]) {
                max = right;
            }

        if (max != root) {
            swap(arr, max, root);
            heapify(arr, size, max);
        }

    }


    public void sort(int[] arr) {
        int n = arr.length;

        buildMaxHeap(arr);

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        heapSort hp = new heapSort();
        int [] array = {12,23,19,20,17,15,16,80,78,56,39,100,116,113,110};
        System.out.println("Before Sorting");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\nAfter Sorting");
        hp.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

}
