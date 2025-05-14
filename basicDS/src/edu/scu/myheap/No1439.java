package edu.scu.myheap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class No1439 {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<LinkedList<Integer>> pq=new PriorityQueue<>((a, b)->a.get(0)-b.get(0));
        HashSet<LinkedList<Integer>> set=new HashSet<>();
        //int[] cols=new int[mat.length];
        int sum=0;
        LinkedList<Integer> temp=new LinkedList<>();
        for (int i=0;i<mat.length;i++){
            sum+=mat[i][0];
            temp.add(0);
        }
        set.add(temp);
        pq.add(temp);
        temp.addFirst(sum);
        int up=mat[0].length-1;
        while (k>0&&!pq.isEmpty()){
            k--;
            LinkedList<Integer> temp2=pq.poll();
            if (k==0) return temp2.get(0);
            for (int i=0;i<mat.length;i++){
                int curindex=temp2.get(i+1);
                if (curindex<up){
                    Integer[] use=temp2.toArray(new Integer[temp2.size()]);
                    use[0]+=mat[i][curindex+1]-mat[i][curindex];
                    use[i+1]=curindex+1;
                    LinkedList<Integer> add=new LinkedList<>(Arrays.asList(use));
                    if(!set.contains(add)){
                        System.out.println(add);
                        pq.add(new LinkedList<>(add));
                        set.add(add);
                    }
                }
            }
        }
        return -1;
    }
}
