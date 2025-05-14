package edu.scu.myheap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy=new PriorityQueue<>((p,q)->q[0]-p[0]);
        PriorityQueue<int[]> sell=new PriorityQueue<>((p,q)->p[0]-q[0]);
        for (int[] order : orders) {
            int type=order[2];
            if (type==0){
                //buy
                while(!sell.isEmpty()&&order[0]>=sell.peek()[0]){
                    int[] temp=sell.peek();
                    int buyamount=order[1];
                    int sellamount=temp[1];
                    if (sellamount>=buyamount){
                        sell.poll();
                        if (sellamount>buyamount){
                            sell.add(new int[]{temp[0],temp[1]-buyamount,1});
                        }
                        order[1]=0;
                        break;
                    }else{
                        order[1]-=sell.poll()[1];
                    }
                }
                if (order[1]>0){
                    buy.offer(order);
                }
            }else{
                //sell
                while(!buy.isEmpty()&&order[0]<=buy.peek()[0]){
                    int[] temp=buy.peek();
                    int sellamount=order[1];
                    int buyamount=temp[1];
                    if (buyamount>=sellamount){
                        buy.poll();
                        if (buyamount>sellamount){
                            buy.add(new int[]{temp[0],temp[1]-sellamount,0});
                        }
                        order[1]=0;
                        break;
                    }else{
                        order[1]-=buy.poll()[1];
                    }
                }
                if (order[1]>0){
                    sell.offer(order);
                }
            }
        }
        long res=0;
        while (!sell.isEmpty()){
            res+=sell.poll()[1];
            res%=(1e9+7);
        }
        while (!buy.isEmpty()){
            res+=buy.poll()[1];
            res%=(1e9+7);
        }
        //System.out.println(res);
        return (int)res;
    }
}
