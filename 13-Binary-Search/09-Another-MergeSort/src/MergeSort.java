import java.util.Arrays;


public class MergeSort {

    private MergeSort(){}

    // 自顶向下的归并排序
    public static <E extends Comparable<E>> void sort(E[] arr){

        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length, temp);
    }

    // 对 arr[l, r) 范围进行排序
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp){

        if (r - l <= 1) return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid, r, temp);

        if(arr[mid - 1].compareTo(arr[mid]) > 0)
            merge(arr, l, mid, r, temp);
    }

    // 合并 arr[l, mid) 和 arr[mid, r) 两个区间的元素
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] aux){

        System.arraycopy(arr, l, aux, l, r - l);

        int i = l, j = mid;

        // 每轮循环为 arr[k] 赋值
        for(int k = l; k < r; k ++){

            if(i >= mid){
                arr[k] = aux[j]; j ++;
            }
            else if(j >= r){
                arr[k] = aux[i]; i ++;
            }
            else if(aux[i].compareTo(aux[j]) <= 0){
                arr[k] = aux[i]; i ++;
            }
            else{
                arr[k] = aux[j]; j ++;
            }
        }
    }

    public static void main(String[] args){

        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("MergeSort", arr);
    }
}
