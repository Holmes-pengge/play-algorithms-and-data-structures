// Leetcode 215
// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/

import java.util.PriorityQueue;

class Solution2 {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < k; i ++)
            pq.add(nums[i]);

        for(int i = k; i < nums.length; i ++)
            if(!pq.isEmpty() && nums[i] > pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }

        return pq.peek();
    }
}