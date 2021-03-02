import java.util.Arrays;

public class BubbleSort {

    private BubbleSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){

        for(int i = 0; i + 1 < data.length; i ++){

            // arr[0, i) 已排好序
            // 通过冒泡在 arr[i] 位置放上合适的元素
            for(int j = data.length - 1; j > i; j --)
                if(data[j - 1].compareTo(data[j]) > 0)
                    swap(data, j - 1, j);
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data){

        for(int i = 0; i + 1 < data.length; i ++){

            // arr[0, i) 已排好序
            // 通过冒泡在 arr[i] 位置放上合适的元素
            boolean isSwapped = false;
            for(int j = data.length - 1; j > i; j --)
                if(data[j - 1].compareTo(data[j]) > 0){
                    swap(data, j - 1, j);
                    isSwapped = true;
                }

            if(!isSwapped) break;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] data){

        for(int i = 0; i + 1 < data.length; ){

            // arr[0, i) 已排好序
            // 通过冒泡在 arr[i] 位置放上合适的元素
            int lastSwappedIndex = data.length - 1;
            for(int j = data.length - 1; j > i; j --)
                if(data[j - 1].compareTo(data[j]) > 0){
                    swap(data, j - 1, j);
                    lastSwappedIndex = j - 1;
                }

            i = lastSwappedIndex + 1;
        }
    }

    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("BubbleSort", arr);
        SortingHelper.sortTest("BubbleSort2", arr2);
        SortingHelper.sortTest("BubbleSort3", arr3);
        System.out.println();


        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("BubbleSort", arr);
        SortingHelper.sortTest("BubbleSort2", arr2);
        SortingHelper.sortTest("BubbleSort3", arr3);
    }
}
