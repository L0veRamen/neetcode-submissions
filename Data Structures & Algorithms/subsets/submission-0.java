class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, res, path);
        return res;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> path) {
        // base case
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不选 nums[i]
        dfs(i + 1, nums, res, path);

        // 选nums[i]
        path.add(nums[i]);
        dfs(i + 1, nums, res, path);
        path.removeLast();
    }
}
