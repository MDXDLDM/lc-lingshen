package edu.scu.myheap;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class No3296 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        TreeMap<Pair<Long,Integer>, Pair<Integer,Integer>> map = new TreeMap<>(new Comparator<Pair<Long, Integer>>() {
            @Override
            public int compare(Pair<Long, Integer> o1, Pair<Long, Integer> o2) {
                if (o1.getKey() == o2.getKey()){
                    return Integer.compare(o1.getValue(), o2.getValue());
                }else{
                    return Double.compare(o1.getKey(), o2.getKey());
                }
            }
        });//key作为nextvalue进行排序,pair中key为一次所需时间value为当前次数
        for (int i = 0; i < workerTimes.length; i++) {
            map.put(new Pair<>((long)workerTimes[i],i),new Pair<>(workerTimes[i],1));
        }
        while(mountainHeight>1){
            mountainHeight--;
            Map.Entry<Pair<Long, Integer>, Pair<Integer, Integer>> e=map.firstEntry();
            Pair<Long, Integer> time=e.getKey();
            map.remove(time);
            Pair<Integer,Integer> pair=e.getValue();
            long realtime=time.getKey();
            System.out.println(realtime);
            int value=pair.getKey();
            int count=pair.getValue();

            realtime+=(long)value*++count;
            map.put(new Pair<>(realtime, time.getValue()),new Pair<>(value,count));
        }
        return map.firstEntry().getKey().getKey();
    }
}
