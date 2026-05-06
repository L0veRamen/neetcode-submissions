class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        // Arrays.setAll(g, i -> new ArrayList<>());
        for(int i = 0; i < numCourses;i++){
            g[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }

        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 0 && dfs(i, g, colors)) {
                return false; // 有环
            }
        }
        return true; // 没有环
    }

    // 返回 true 表示找到了环
    private boolean dfs(int x, List<Integer>[] g, int[] colors) {
        colors[x] = 1; // x 正在访问中
        for (int y : g[x]) {
            // 情况一：colors[y] == 1，表示发生循环依赖，找到了环
            // 情况二：colors[y] == 0，未知，继续递归 y 获取信息
            // 情况三：colors[y] == 2，继续递归 y 只会重蹈覆辙，和之前一样无法找到环
            if (colors[y] == 1 || colors[y] == 0 && dfs(y, g, colors)) {
                return true; // 找到了环
            }
        }
        colors[x] = 2; // x 完全访问完毕，从 x 出发无法找到环
        return false; // 没有找到环
    }
}
