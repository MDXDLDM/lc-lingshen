package edu.scu.myheap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //int[] res=new int[2];
        PriorityQueue<double[]> pq=new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[0]==o2[0]){
                    return Double.compare(o1[1],o2[1]);
                }
                return Double.compare(o1[0],o2[0]);
            }
        });
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            pq.add(new double[]{(double) arr[i]/arr[len-1],i,len-1});
        }
        while(!pq.isEmpty()){
            k--;
            double[] temp=pq.poll();
            if(k==0){
                return new int[]{arr[(int)temp[1]],arr[(int)temp[2]]};
            }
            double up=temp[1];double down=temp[2];
            if (down-up>1){
                pq.offer(new double[]{(double) arr[(int)up]/arr[(int)(down-1)],up,down-1});
                //System.out.println(pq.peek());
            }
        }
        return new int[2];
    }
}
