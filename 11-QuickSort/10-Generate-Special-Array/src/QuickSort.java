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

    // 在 sort2 的 partition2 中，我们使用待处理数组区间的中间值作为标定点
    public static <E extends Comparable<E>> void sort2(E[] arr){
        sort2(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r){

        if(l >= r) return;

        int p = partition2(arr, l, r);
        sort2(arr, l, p - 1);
        sort2(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r){

        // 使用中间值作为标定点
        swap(arr, l, (l + r) / 2);

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
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2", arr2);

        System.out.println();


        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2", arr2);
        System.out.println();


        arr = ArrayGenerator.generateSpecialArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Special Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2", arr2);
        System.out.println();
    }
}
