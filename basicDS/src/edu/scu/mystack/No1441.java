package edu.scu.mystack;

import java.util.ArrayList;
import java.util.List;

public class No1441 {
    public List<String> buildArray(int[] target, int n) {
        int index=0;int count=1;
        List<String> list = new ArrayList<String>();
        while (index < target.length) {
            while(count<target[index]){
                list.add("Push");
                list.add("Pop");
                count++;
            }
            list.add("Push");
            index++;count++;
        }
        return list;
    }
}
