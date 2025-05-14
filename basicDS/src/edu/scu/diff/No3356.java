package edu.scu.diff;

public class No3356 {
    public int minZeroArray(int[] nums, int[][] queries) {
//        int[][] tool=new int[queries.length][nums.length+1];
//        int[] dec=new int[nums.length+1];
//        for (int i = 0; i < queries.length; i++) {
//            int start=queries[i][0];
//            int end=queries[i][1];
//            dec[start]+=queries[i][2];
//            dec[end+1]-=queries[i][2];
//            tool[i]=dec.clone();
//        }
//        int left=0;int right=queries.length-1;
//        boolean flag=true;
//        int excount=0;
//        while(left<=right){
//            flag=true;
//            int mid=left+(right-left>>1);
//            int[] temp=tool[mid];
//            int count=0;
//            for (int i = 0; i < nums.length; i++) {
//                if(nums[i]==0)excount++;
//                count+=temp[i];
//                if(count<nums[i]){
//                    flag=false;
//                    break;
//                }
//            }
//            if(excount==nums.length){
//                return 0;
//            }
//            if(flag){
//                right=mid-1;
//            }else{
//                left=mid+1;
//            }
//            excount=0;
//        }
//        System.out.println(left+" "+right);
//        return left==queries.length?-1:right+2;
        int[] dec= new int[nums.length+1];
        int tempindex=0;
        int tempsum=0;boolean flag=false;
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(start<=tempindex&end>=tempindex-1){
                dec[tempindex]+=queries[i][2];
            }else{
                dec[start]+=queries[i][2];
            }
            dec[end+1]-=queries[i][2];
            while(true){
                if(nums[tempindex]!=0){
                    flag=true;
                }
                if(nums[tempindex]>tempsum+dec[tempindex]){
                    //flag=true;
                    break;
                }
                tempsum+=dec[tempindex];
                tempindex++;
                if(tempindex==nums.length){
                    return !flag?0:i+1;
                }
            }
        }
        return -1;
    }
}
