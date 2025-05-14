package edu.scu.unionfind;

import java.util.HashSet;
import java.util.Set;

public class No3493 {
    public int numberOfComponents(int[][] properties, int k) {
        UnionFind unionFind=new UnionFind(properties.length);
        Set<Integer>[] sets=new Set[properties.length];
        for (int i = 0; i < properties.length; i++) {
            sets[i]=new HashSet<>();
            for (int j=0;j<properties[i].length;j++){
                sets[i].add(properties[i][j]);
            }
        }
        for (int i = 0; i < properties.length; i++) {
            Set<Integer> set=sets[i];
            for (int j=0;j<properties.length;j++){
                if (j==i) continue;
                Set<Integer> set2=sets[j];
                int count=0;
                for (int value:set){
                    if (set2.contains(value)) count++;
                }
                if (count>=k){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.sectioncount;
    }
}
