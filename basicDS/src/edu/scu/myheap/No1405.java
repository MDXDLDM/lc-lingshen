package edu.scu.myheap;

import java.util.Map;
import java.util.PriorityQueue;

public class No1405 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((p,q)->(q[0]-p[0]));
        if (a>0) {
            pq.add(new int[]{a,'a'});
        }
        if (b>0) {
            pq.add(new int[]{b,'b'});
        }
        if (c>0) {
            pq.add(new int[]{c,'c'});
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] max=pq.poll();
            char temp=(char)max[1];
            if (sb.length()>=2&&sb.charAt(sb.length()-1)==temp&&sb.charAt(sb.length()-2)==temp){
                if (pq.isEmpty()){
                    break;
                }
                int[] secondMax=pq.poll();
                sb.append((char)secondMax[1]);
                if (secondMax[0]>1){
                    pq.add(new int[]{secondMax[0]-1,secondMax[1]});
                }
                pq.add(max);
            }else{
                sb.append(temp);
                if (max[0]>1){
                    pq.add(new int[]{max[0]-1,max[1]});
                }
            }
        }
        return sb.toString();
    }
}
