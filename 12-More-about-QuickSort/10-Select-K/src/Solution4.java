// https://leetcode-cn.com/problems/smallest-k-lcci/

import java.util.Arrays;

public class Solution4 {

    public int[] smallestK(int[] arr, int k) {

        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
