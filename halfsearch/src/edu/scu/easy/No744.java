package edu.scu.easy;

public class No744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int fisrtindex=0;int lastindex=letters.length-1;//左闭右闭
        while(fisrtindex<=lastindex){
            int mid=(lastindex-fisrtindex)/2+fisrtindex;
            if(letters[mid]>target){
                lastindex=mid-1;
            }else{
                fisrtindex=mid+1;
            }
        }
        return fisrtindex==letters.length?letters[0]:letters[fisrtindex];
    }
}
