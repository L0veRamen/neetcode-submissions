class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(p,q) -> p[0] - q[0]);

        List<int[]> res = new ArrayList<>();
        for(int[] p: intervals){
            int m = res.size();
            if(m > 0 && p[0] <= res.get(m - 1)[1]){
                res.get(m - 1)[1] = Math.max(res.get(m - 1)[1], p[1]);
            }else{
                res.add(p);
            }
        } 
        return res.toArray(new int[res.size()][]);
    }
}
