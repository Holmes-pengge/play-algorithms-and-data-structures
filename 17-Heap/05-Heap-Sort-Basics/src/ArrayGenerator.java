import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator(){}

    public static Integer[] generateOrderedArray(int n){

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i ++)
            arr[i] = i;
        return arr;
    }

    // 生成一个长度为 n 的随机数组，每个数字的范围是 [0, bound)
    public static Integer[] generateRandomArray(int n, int bound){

        Integer[] arr = new Integer[n];
        Random rnd = new Random();
        for(int i = 0; i < n; i ++)
            arr[i] = rnd.nextInt(bound);
        return arr;
    }

    // 针对以中间点为标定点的快速排序，生成一个特殊的测试用例
    // 使得这样的快速排序产生退化
    public static Integer[] generateSpecialArray(int n){

        Integer[] arr = new Integer[n];
        generateSpecialArray(arr, 0, arr.length - 1, 0);
        return arr;
    }

    private static void generateSpecialArray(Integer[] arr, int l, int r, int value){

        if(l > r) return;

        int mid = (l + r) / 2;
        arr[mid] = value;

        swap(arr, l, mid);
        generateSpecialArray(arr, l + 1, r, value + 1);
        swap(arr, l, mid);
    }

    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}