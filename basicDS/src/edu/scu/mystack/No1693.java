package edu.scu.mystack;

public class No1693 {
    public int minSwaps(String s) {
//        int precount=0;
//        int res=0;
//        int firstindex=0;int lastindex=s.length()-1;
//        while(firstindex<lastindex){
//            char c=s.charAt(firstindex);
//            if(c=='['){
//                precount++;
//            }else{
//                if (precount==0){
//                    res++;
//                    while(lastindex>firstindex&&s.charAt(lastindex)!='['){
//                        lastindex--;
//                    }
//                    lastindex--;
//                    precount++;
//                }else{
//                    precount--;
//                }
//            }
//            firstindex++;
//        }
        int res=0;
        int precount=0;
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if (chars[i]=='['){
                precount++;
            //理解为与最右侧的右括号进行交换，所以不影响后续的判断
            }else if (precount==0){
                res++;
                precount++;
            }else{
                precount--;
            }
        }
        return res;
    }
}
