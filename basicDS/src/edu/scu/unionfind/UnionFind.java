package edu.scu.unionfind;

import java.util.Arrays;

public class UnionFind {

    private int[] father;
    private int[] size;
    int sectioncount;

    public UnionFind() {

    }
    public UnionFind(int n) {
        father = new int[n];
        size = new int[n];
        sectioncount = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        Arrays.fill(size, 1);
    }

    public int find(int p) {
        if (p!=father[p]) {
            //找到最深父节点
            //递归调用同时将路径上的所有节点都指向共同的最深父节点
            father[p]=find(father[p]);
        }
        return father[p];
    }

    public boolean isSame(int p, int q) {
        return find(p) == find(q);
    }

    public boolean union(int p, int q) {
        int from=find(p);
        int to=find(q);
        if (from==to){
            return false;
        }
        //将from的根节点指向to的根节点
        father[from]=to;
        //合并大小
        size[to]+=size[from];
        //连通模块减一
        sectioncount--;
        return true;
    }
}
