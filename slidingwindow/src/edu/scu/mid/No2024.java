package edu.scu.mid;

public class No2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
//        int rest=k;int max=0;
//        int firstindex=0;
//        while(firstindex<answerKey.length()&&answerKey.charAt(firstindex)!='T'){
//            firstindex++;
//        }
//        if(firstindex==answerKey.length()||k==answerKey.length()){
//            return answerKey.length();
//        }
//        int lastindex=firstindex;
//        while(lastindex<answerKey.length()){
//            while(firstindex<answerKey.length() && answerKey.charAt(lastindex)!='T'&&rest==0){
//                if(answerKey.charAt(firstindex)!='T'){
//                    rest++;
//                }
//                firstindex++;
//            }
//            if(answerKey.charAt(lastindex)!='T'){
//                rest--;
//            }
//            max=Math.max(max,lastindex-firstindex+1+rest);
//            if(lastindex-firstindex+1+rest>=answerKey.length()) return answerKey.length();
//            lastindex++;
//        }
//        firstindex=0;rest=k;
//        while(firstindex<answerKey.length()&&answerKey.charAt(firstindex)!='F'){
//            firstindex++;
//        }
//        if(firstindex==answerKey.length()||k==answerKey.length()){
//            return answerKey.length();
//        }
//        lastindex=firstindex;
//        while(lastindex<answerKey.length()){
//            while(firstindex<answerKey.length() && answerKey.charAt(lastindex)!='F'&&rest==0){
//                if(answerKey.charAt(firstindex)!='F'){
//                    rest++;
//                }
//                firstindex++;
//            }
//            if(answerKey.charAt(lastindex)!='F'){
//                rest--;
//            }
//            max=Math.max(max,lastindex-firstindex+1+rest);
//            if(lastindex-firstindex+1+rest>=answerKey.length()) return answerKey.length();
//            lastindex++;
//        }
//        return max;
        int firstindex=0;int lastindex=0;
        int[] hash=new int[2];
        int max=0;
        while(lastindex<answerKey.length()){
            hash[(answerKey.charAt(lastindex)/2)%2]++;
            while(firstindex<answerKey.length()&&hash[0]>k&&hash[1]>k){
                hash[(answerKey.charAt(firstindex)/2)%2]--;
                firstindex++;
            }
            max=Math.max(max,lastindex-firstindex+1);
            lastindex++;
        }
        return max;
    }
}
