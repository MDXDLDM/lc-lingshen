package edu.scu.mid;

public class No1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] nums=new int[s.length()];
        for(int i=0;i<s.length();i++){
            nums[i]=s.charAt(i)-t.charAt(i);
            nums[i]=Math.abs(nums[i]);
        }
        int current=0;int max=0;int sum=0;
        int firstindex=0;int lastindex=0;
        while(lastindex<s.length()){
            sum+=nums[lastindex];
            current++;
            if(sum>maxCost){
                while(firstindex<=lastindex&&sum>maxCost){
                    sum-=nums[firstindex];
                    firstindex++;
                    current--;
                }
            }
            lastindex++;
            max=Math.max(max,current);
        }
        return max;
    }
}
