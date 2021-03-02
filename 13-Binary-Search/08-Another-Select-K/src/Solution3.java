// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/

import java.util.Random;

// 非递归
class Solution3 {

    public int findKthLargest(int[] nums, int k) {

        Random rnd = new Random();
        return selectK(nums, nums.length - k, rnd);
    }

    private int selectK(int[] arr, int k, Random rnd){

        int l = 0, r = arr.length;
        // 在 arr[l, r) 范围里寻找第 k 小的数字
        while(l < r){

            int p = partition(arr, l, r, rnd);

            if(k == p) return arr[p];

            if(k < p) r = p;
            else l = p + 1;
        }

        throw new RuntimeException("No Solution");
    }

    // 在 arr[l, r) 进行 partition
    private int partition(int[] arr, int l, int r, Random rnd){

        // 生成 [l, r) 之间的随机索引
        int p = l + rnd.nextInt(r - l);
        swap(arr, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r) >= v
        int i = l + 1, j = r - 1;
        while(true){

            while(i <= j && arr[i] < arr[l])
                i ++;

            while(j >= i && arr[j] > arr[l])
                j --;

            if(i >= j) break;

            swap(arr, i, j);

            i ++;
            j --;
        }

        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
