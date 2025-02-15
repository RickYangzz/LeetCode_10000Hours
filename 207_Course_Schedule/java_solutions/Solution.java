import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacencyList = new List[numCourses];
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        List<Integer> ans = new ArrayList<>();

        for(int[] pair : prerequisites){
            int course = pair[0];
            int pre = pair[1];
            if(adjacencyList[pre] == null){
                adjacencyList[pre] = new ArrayList<>();
            }
            adjacencyList[pre].add(course);
            indegree[course] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int current = q.poll();
            ans.add(current);
            
            if(adjacencyList[current] == null) continue;

            for (int node : adjacencyList[current]) {
                indegree[node] -= 1;

                if(indegree[node] == 0){
                    q.offer(node);
                }
            }
            
        }

        return ans.size() == numCourses;
    }
}