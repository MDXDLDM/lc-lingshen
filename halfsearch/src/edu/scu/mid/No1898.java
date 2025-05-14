package edu.scu.mid;

public class No1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int right=removable.length;
        int left=0;
        while(left<=right){
            int mid=left+(right-left>>1);
            int[] flag=new int[s.length()];
            for(int i=0;i<mid;i++){
                flag[removable[i]]=1;
            }
            int index=0;
            for(int i=0;i<s.length();i++){
                if(index==p.length())break;
                if(flag[i]==1)continue;
                if(s.charAt(i)==p.charAt(index)){
                    index++;
                }
            }
            if(index==p.length()){
                //说明此时还能继续删
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
}
