package edu.scu.unionfind;

import java.util.*;

public class No721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        StringUnion su=new StringUnion(accounts.size());
        Set<String>[] sets=new Set[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            sets[i]=new HashSet<>();
            List<String> account=accounts.get(i);
            sets[i].addAll(account);
            sets[i].remove(account.get(0));
        }
        for (int i = 0; i < accounts.size(); i++) {
            for (int j=1;j<accounts.get(i).size();j++) {
                String str=accounts.get(i).get(j);
                for (int k=0;k<i;k++){
                    Set<String> set=sets[k];
                    if (set.contains(str)){
                        su.union(k,i);
                        break;
                    }
                }
            }
        }
        List<List<String>> res=new ArrayList<>();
        for (int i=0;i<accounts.size();i++){
            int fa= su.find(i);
            if (fa!=i){
                sets[fa].addAll(sets[i]);
            }else{
                List<String> list=new LinkedList<>();
                list.addAll(sets[i]);
                Collections.sort(list);
                list.add(0,accounts.get(i).get(0));
                res.add(list);
            }
        }
        return res;
    }
    private static class StringUnion{
        int[] indexs;
        public StringUnion(int n){
            indexs = new int[n];
            for(int i=0; i<n; i++){
                indexs[i] = i;
            }
        }

        public int find(int i){
            if (indexs[i]!=i){
                indexs[i] = find(indexs[i]);
            }
            return indexs[i];
        }

        public void union(int i, int j){
            int from=find(i);
            int to=find(j);
            if (from!=to){
                indexs[from]=to;
            }
        }
    }
}
