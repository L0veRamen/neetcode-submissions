class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         // Build adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int [] inDegree = new int [numCourses];
        for(int [] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);  // pre[1] → pre[0]
            inDegree[pre[0]]++;
        }

        // add all nodes with inDegree 0 to queue
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        //process queue
        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            count++;
            for(int next: graph.get(course)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        return count == numCourses;


    }
}
