import java.util.Arrays;


public class MergeSort {

    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){

        sort(arr, 0, arr.length - 1, 0);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, int depth){

        // 生成深度字符串
        String depthString = generateDepthString(depth);

        // 打印当前 sort 处理的数组区间信息
        System.out.print(depthString);
        System.out.println(String.format("mergesort arr[%d, %d]", l, r));

        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, depth + 1);
        sort(arr, mid + 1, r, depth + 1);

        // 打印这次 merge 要处理的区间范围
        System.out.print(depthString);
        System.out.println(String.format("merge arr[%d, %d] and arr[%d, %d]", l, mid, mid + 1, r));

        merge(arr, l, mid, r);

        // 打印 merge 后的数组
        System.out.print(depthString);
        System.out.print(String.format("after mergesort arr[%d, %d] :", l, r));
        for(E e: arr)
            System.out.print(e + " ");
        System.out.println();
    }

    private static String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }


    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){

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

    public static void main(String[] args){

        Integer[] arr = {7, 1, 4, 2, 8, 3, 6, 5};
        SortingHelper.sortTest("MergeSort", arr);
    }
}
