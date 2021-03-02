import java.util.Arrays;


public class MergeSort {

    private MergeSort(){}

    public static <E extends Comparable> void sort(E[] arr){

        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable> void sort(E[] arr, int l, int r){

        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    private static <E extends Comparable> void merge(E[] arr, int l, int mid, int r){

        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = temp[j - l]; j ++;
            }
            else if(j > r){
                arr[k] = temp[i - l]; i ++;
            }
            else if(temp[i - l].compareTo(temp[j - l]) <= 0){
                arr[k] = temp[i - l]; i ++;
            }
            else{
                arr[k] = temp[j - l]; j ++;
            }
        }
    }

    public static <E extends Comparable> void sort2(E[] arr){

        E[] temp = Arrays.copyOf(arr, arr.length);
        sort2(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable> void sort2(E[] arr, int l, int r, E[] temp){

        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        sort2(arr, l, mid, temp);
        sort2(arr, mid + 1, r, temp);

        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge2(arr, l, mid, r, temp);
    }

    private static <E extends Comparable> void merge2(E[] arr, int l, int mid, int r, E[] temp){

        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = temp[j]; j ++;
            }
            else if(j > r){
                arr[k] = temp[i]; i ++;
            }
            else if(temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i]; i ++;
            }
            else{
                arr[k] = temp[j]; j ++;
            }
        }
    }

    public static void main(String[] args){

        int n = 5000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSort2", arr2);
    }
}
