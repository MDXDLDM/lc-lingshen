package edu.scu.graphic;

import java.util.*;

public class No3 {
    boolean res=true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[] preClasses=new int[numCourses];
//        Map<Integer, List<Integer>> map=new HashMap<>();
//        for (int[] prerequisite : prerequisites) {
//            if(prerequisite[0]==prerequisite[1]) return false;
//            preClasses[prerequisite[0]]++;
//            map.putIfAbsent(prerequisite[1], new ArrayList<>());
//            map.get(prerequisite[1]).add(prerequisite[0]);
//        }
//        int[] visited=new int[numCourses];
//        for(int i=0;i<numCourses;i++){
//            dfs(i,map,new int[numCourses],visited);
//            if(!res) break;
//        }
//        return res;
        //邻接表做法
        List<List<Integer>> nextGraph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nextGraph.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int max=0;
        for(int[] prerequisite : prerequisites) {
            nextGraph.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0) {
                queue.add(i);
                max++;
            }
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> neighbours = nextGraph.get(course);
            for(Integer neighbour : neighbours) {
                indegree[neighbour]--;
                if(indegree[neighbour]==0) {
                    queue.add(neighbour);
                    max++;
                }
            }
        }
        return max==numCourses;
    }
    private void dfs(int i, Map<Integer, List<Integer>> map, int[] used, int[] visited){
        if (visited[i]==1) return;
        if (!map.containsKey(i)){
            return;
        }
        used[i]=1;
        List<Integer> list = map.get(i);
        for(int j:list){
            if (used[j]==1){
                //环开始
                res=false;
                return;
            }else{
                dfs(j,map,used,visited);
            }
        }
        used[i]=0;
        visited[i]=1;
    }
}
