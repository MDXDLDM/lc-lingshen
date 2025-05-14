package edu.scu.myheap;

import java.util.*;

public class No373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        Set<List<Integer>> set = new HashSet<>();
        pq.add(new int[]{nums1[0]+nums2[0],0, 0});
        set.add(new ArrayList<>(Arrays.asList(0,0)));
        int index=0;
        List<List<Integer>> result = new ArrayList<>();
        while(index<k&&!pq.isEmpty()){
            int[] temp = pq.poll();
            int row = temp[1];int col=temp[2];
            result.add(new ArrayList<>(Arrays.asList(nums1[row],nums2[col])));
            index++;
            if (index==k) return result;
            if (row+1<nums1.length && !set.contains(Arrays.asList(row+1,col))){
                set.add(new ArrayList<>(Arrays.asList(row+1,col)));
                pq.add(new int[]{nums1[row+1]+nums2[col], row+1, col});
            }
            if (col+1<nums2.length && !set.contains(Arrays.asList(row,col+1))){
                set.add(new ArrayList<>(Arrays.asList(row,col+1)));
                pq.add(new int[]{nums1[row]+nums2[col+1], row, col+1});
            }
        }
        return result;
    }
}
