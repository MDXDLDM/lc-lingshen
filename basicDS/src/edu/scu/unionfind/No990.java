package edu.scu.unionfind;

public class No990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String equation : equations) {
            char flag=equation.charAt(1);
            if (flag=='!') continue;
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            uf.union(x-'a', y-'a');
        }
        for (String equation : equations) {
            char flag=equation.charAt(1);
            if (flag=='!'){
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                if (uf.isSame(x-'a', y-'a')){
                    return false;
                }
            }
        }
        return true;
    }
}
