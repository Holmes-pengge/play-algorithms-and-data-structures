// https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
import java.util.Arrays;

class Solution {

    public int shipWithinDays(int[] weights, int D) {

        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while(l < r){

            int mid = l + (r - l) / 2;
            if(days(weights,mid) <= D)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int days(int[] weights, int k){

        int cur = 0, res = 0;
        for(int weight: weights)
            if(cur + weight <= k) cur += weight;
            else{
                res ++;
                cur = weight;
            }
        res ++;
        return res;
    }
}
