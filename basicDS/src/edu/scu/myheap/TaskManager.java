package edu.scu.myheap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskManager {
    HashMap<Integer,Integer> tasksp;//priority
    HashMap<Integer,Integer> tasksuser;
    PriorityQueue<int[]> pq;
    public TaskManager(List<List<Integer>> tasks) {
        pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]==o2[2]?o2[1]-o1[1]==0?o2[0]-o1[0]:o2[1]-o1[1]:o2[2]-o1[2];
            }
        });
        tasksp=new HashMap<>();
        tasksuser=new HashMap<>();
        for (List<Integer> task : tasks) {
            int userid=task.get(0);
            int taskid=task.get(1);
            int priority=task.get(2);
            tasksp.put(taskid,priority);
            tasksuser.put(taskid,userid);
            pq.add(new int[]{userid,taskid,priority});
        }
    }

    public void add(int userId, int taskId, int priority) {
        tasksp.put(taskId,priority);
        tasksuser.put(taskId,userId);
        pq.add(new int[]{userId,taskId,priority});
    }

    public void edit(int taskId, int newPriority) {
        tasksp.put(taskId,newPriority);
        pq.add(new int[]{tasksuser.get(taskId),taskId,newPriority});
    }

    public void rmv(int taskId) {
        tasksp.remove(taskId);
        tasksuser.remove(taskId);
    }

    public int execTop() {
        while(!pq.isEmpty()&&(!tasksp.containsKey(pq.peek()[1])||pq.peek()[2]!=tasksp.get(pq.peek()[1]))) {
            pq.poll();
        }
        if (!pq.isEmpty()){
            int[] top=pq.poll();
            tasksp.remove(top[1]);
            tasksuser.remove(top[1]);
            return top[0];
        }
        return -1;
    }
}
