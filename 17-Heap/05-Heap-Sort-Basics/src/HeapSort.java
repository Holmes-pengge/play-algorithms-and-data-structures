import java.util.Arrays;

public class HeapSort {

    private HeapSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){

        MaxHeap<E> maxHeap = new MaxHeap<>();
        for(E e: data)
            maxHeap.add(e);

        for(int i = data.length - 1; i >= 0; i --)
            data[i] = maxHeap.extractMax();
    }

    public static void main(String[] args) {

        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        SortingHelper.sortTest("HeapSort", arr4);
    }
}
