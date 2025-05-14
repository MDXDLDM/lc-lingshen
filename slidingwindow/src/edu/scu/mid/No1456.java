package edu.scu.mid;
//定长子串中元音的最大数目
public class No1456 {
    public int maxVowels(String s, int k) {
//        int maxres=0;
//        int firstindex=0;
//        int lastindex=0;
//        for(;lastindex<k;lastindex++){
//            if(judge(s.charAt(lastindex))){
//                maxres++;
//            }
//        }
//        int current=maxres;
//        //firstindex++;lastindex++;
//        for(;lastindex<s.length();lastindex++,firstindex++){
//            if(judge(s.charAt(lastindex)))current++;
//            if(judge(s.charAt(firstindex)))current--;
//            maxres=Math.max(maxres,current);
//        }
//        return maxres;
        int max=0;
        for(int i=0;i<s.length()-k;i++){
            if(judge(s.charAt(i))||i==s.length()-1-k){
                max=Math.max(max,total(s,i,k));
            }
        }
        return max;
    }
    private int total(String s,int index,int count){
        int current=0;
        for(int i=index;i<count+index;i++){
            if(judge(s.charAt(i)))current++;
        }
        return current;
    }
    private boolean judge(char a){
        return a=='a'||a=='e'||a=='i'||a=='o'||a=='u';
    }
}
