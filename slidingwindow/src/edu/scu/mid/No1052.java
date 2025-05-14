package edu.scu.mid;

public class No1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int custnum=0;int basic=0;
        int max=0;
        int firstindex=0;int lastindex=0;
        while(lastindex<customers.length){
            if(lastindex<minutes){
                if(grumpy[lastindex]==1){
                    custnum+=customers[lastindex];
                    max=Math.max(max,custnum);
                }else{
                    basic+=customers[lastindex];
                }
                lastindex++;
                continue;
            }
            if(grumpy[lastindex]==1){
                custnum+=customers[lastindex];
            }else{
                basic+=customers[lastindex];
            }
            if(grumpy[firstindex]==1){
                custnum-=customers[firstindex];
            }
            max=Math.max(max,custnum);
            firstindex++;
            lastindex++;
        }
        return max+basic;
    }
}
