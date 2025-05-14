package edu.scu.mystack;

public class No2211 {
    public int countCollisions(String directions) {
        char[] chars = directions.toCharArray();
        int leftindex=0;int rightindex=chars.length-1;
        while(leftindex<chars.length&&chars[leftindex]=='L'){
            leftindex++;
        }
        while(rightindex>=0&&chars[rightindex]=='R'){
            rightindex--;
        }
        int collision=rightindex-leftindex+1;
        for(int i=leftindex; i<=rightindex; i++){
            if(chars[i]=='S'){
                collision--;
            }
        }
        return collision;
    }
}
