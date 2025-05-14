package edu.scu.monotonicStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class No853 {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<double[]> list = new ArrayList<double[]>();
        for (int i = 0; i < position.length; i++) {
            double time=(double)(target-position[i])/speed[i];
            list.add(new double[]{position[i],time});
        }
        Collections.sort(list,(a,b)->Double.compare(b[0],a[0]));
        Stack<double[]> stack = new Stack<double[]>();
        int res=0;
        for(double[] a:list){
            if (!stack.isEmpty()&&stack.peek()[1]>=a[1]){
                continue;
            }
            while(!stack.isEmpty() && stack.peek()[1]<a[1]){
                res++;
                stack.pop();
            }
            stack.push(a);
        }
        res+=stack.size();
        return res;
    }
}
