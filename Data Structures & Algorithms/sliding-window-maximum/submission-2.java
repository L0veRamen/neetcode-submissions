class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1]; 
        Deque<Integer> q = new ArrayDeque<>();
        for(int right = 0; right < n; right++){
            // 1 right in
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[right]){
                q.removeLast(); 
            }
            q.addLast(right);

            // 2 left out
            int left = right - k + 1;
            if(q.getFirst() < left){
                q.removeFirst();
            }

            // 3 update result
            if(left >= 0){
                res[left] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
