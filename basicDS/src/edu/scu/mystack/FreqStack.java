package edu.scu.mystack;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

//public class FreqStack {
//    int count;
//    TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            TreeSet<Integer> set1 = map.get(o1);//此处map的get方法又会依赖于comparator，会导致无限递归
//            TreeSet<Integer> set2 = map.get(o2);
//            if (set1 == null) {
//                return set2 == null ? 0 : -1;
//            }
//            if (set2 == null) {
//                return 1;
//            }
//            int size1 = set1.size();
//            int size2 = set2.size();
//            if (size1 != size2) {
//                return size2 - size1;
//            }else{
//                int index1 = set1.first();
//                int index2 = set2.first();
//                return index2 - index1;
//            }
//        }
//    });//按元素个数降序排列,个数相同则按index降序;
//    public FreqStack(){
//        count=0;
//    }
//    public void push(int val) {
//        if(!map.containsKey(val)) {
//            map.put(val, new TreeSet<>((p,q)->(q-p)));//按下标降序排列
//        }
//        map.get(val).add(count++);
//    }
//
//    public int pop() {
//        int val=-1;
//        if(map.isEmpty()) {
//            return val;
//        }
//        TreeSet<Integer> set = map.firstEntry().getValue();
//        val=map.firstKey();
//        set.remove(set.first());
//        if(set.isEmpty()) {
//            map.remove(val);
//        }
//        return val;
//    }
//}
public class FreqStack {
    private int count;
    private HashMap<Integer, Integer> freq;//存储次数
    private TreeSet<int[]> set;
    public FreqStack(){
        count=0;
        freq=new HashMap<>();
        set=new TreeSet<>((p,q)->{
           if(p[1]==q[1]){
               return q[2]-p[2];
           }else{
               return q[1]-p[1];
           }
        });
    }
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0)+1);
        set.add(new int[]{val,freq.get(val),count++});
    }

    public int pop() {
        int[] tmp=set.pollFirst();
        freq.put(tmp[0], freq.get(tmp[0])-1);
        //set.add(tmp[0],--tmp[1],tmp[2]);
        //此处不需要add是因为在push的时候每一次都add了一个setentry
        return tmp[0];
    }
}
