// https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
class Solution2 {

    public int reversePairs(int[] nums) {

        int[] temp = new int[nums.length];

        return sort(nums, 0, nums.length - 1, temp);
    }

    private int sort(int[] arr, int l, int r, int[] temp){

        if (l >= r)
            return 0;

        int mid = l + (r - l) / 2;
        int res = 0;
        res += sort(arr, l, mid, temp);
        res += sort(arr, mid + 1, r, temp);

        if(arr[mid] > arr[mid + 1])
            res += merge(arr, l, mid, r, temp);
        return res;
    }

    private int merge(int[] arr, int l, int mid, int r, int[] temp){

        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1, res = 0;

        // 每轮循环为 arr[k] 赋值
        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = temp[j]; j ++;
            }
            else if(j > r){
                arr[k] = temp[i]; i ++;
            }
            else if(temp[i] <= temp[j]){
                arr[k] = temp[i]; i ++;
            }
            else{
                res += mid - i + 1;
                arr[k] = temp[j]; j ++;
            }
        }
        return res;
    }
}
