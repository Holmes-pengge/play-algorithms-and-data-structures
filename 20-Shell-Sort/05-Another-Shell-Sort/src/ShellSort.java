import java.util.Arrays;

public class ShellSort {

    private ShellSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){

        int h = data.length / 2;
        while(h >= 1){

            for(int i = h; i < data.length; i ++){
                E t = data[i];
                int j;
                for(j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                    data[j] = data[j - h];
                data[j] = t;
            }

            h /= 2;
        }
    }

    public static void main(String[] args) {

        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("ShellSort", arr);
        SortingHelper.sortTest("MergeSort", arr2);
    }
}
