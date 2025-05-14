package edu.scu.prefix;

import java.util.Arrays;
import java.util.HashMap;

public class No17_05 {
    public String[] findLongestSubarray(String[] array) {
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);int max=0;
        int firstindex=0;
        int lastindex=0;
        for (int i = 0; i < array.length; i++) {
            char temp=array[i].charAt(0);
            sum+=(temp>='A'&&temp<='Z')||(temp>='a'&&temp<='z')?1:-1;
            if(map.containsKey(sum)){
                int before=map.get(sum);
                if(i-before>max){
                    firstindex=before;
                    lastindex=i;
                    max=i-before;
                }
            }else{
                map.put(sum,i);
            }
        }
        firstindex=firstindex==-1?0:firstindex;
        return Arrays.copyOfRange(array,firstindex,lastindex+1);
    }
}
