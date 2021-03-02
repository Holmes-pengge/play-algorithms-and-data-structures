import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){

        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd){

        if(l >= r) return;

        int p = partition(arr, l, r, rnd);
        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd){

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...j] < v ; arr[j+1...i] >= v
        int j = l;
        for(int i = l + 1; i <= r; i ++)
            if(arr[i].compareTo(arr[l]) < 0){
                j ++;
                swap(arr, i, j);
            }

        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){

        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("QuickSort", arr);

        arr = ArrayGenerator.generateOrderedArray(n);
        SortingHelper.sortTest("QuickSort", arr);

        arr = ArrayGenerator.generateRandomArray(n, 1);
        SortingHelper.sortTest("QuickSort", arr);
    }
}
