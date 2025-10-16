package edu.scu.doubleIndex;

import java.util.Stack;

public class No4 {
    public int trap(int[] height) {
//        //右侧柱子若不是最高，总是与左侧第一个比自己高的接
//        //若是最高，则与左侧最高的接
//        if(height.length == 1) return 0;
//        int leftmaxindex=0;
//        int rightmaxindex=1;
//        int res=0;
//        int current=1;
//        while(current<height.length){
//            int left=height[leftmaxindex];
//            int right=height[rightmaxindex];
//            if(height[current]>=left){
//                int off=0;
//                for(int i=leftmaxindex+1;i<current;i++){
//                    off+=height[i];
//                }
//                res=res-off+(current-leftmaxindex-1)*left;
//                leftmaxindex=current;
//                if(current<height.length-1){
//                    rightmaxindex=current+1;
//                }
//            }else{
//                if(height[current]>right){
//                    rightmaxindex=current;
//                }
//            }
//            current++;
//        }
//        return res;

        //1 --下层到上层计算总面积
//        if (height.length == 1) return 0;
//        int leftindex=0;
//        int rightindex=height.length-1;
//        int h=1;
//        int off=0;
//        int res=0;
//        while(leftindex<=rightindex){
//            if(height[leftindex]<h){
//                off+=height[leftindex];
//                leftindex++;
//            }else{
//                if(height[rightindex]<h){
//                    off+=height[rightindex];
//                    rightindex--;
//                }else{
//                    res+=rightindex-leftindex+1;
//                    h++;
//                }
//            }
//        }
//        return res-off;

        //2 -- 单调栈
//        int res=0;
//        Stack<Integer> stack=new Stack<>();
//        for(int i=0;i<height.length;i++){
//            int h=height[i];
//            //判断左侧现有最低高度是否比现在低
//            while(!stack.isEmpty()&&h>height[stack.peek()]){
//                //可以填坑
//                int lowh=height[stack.pop()];
//                if(stack.isEmpty()){
//                    //代表左侧没有更高的柱子兜底
//                    break;
//                }
//                //最大能填
//                res+=(Math.min(height[stack.peek()],h)-lowh)*(i-stack.peek()-1);
//            }
//            stack.push(i);
//        }
//        return res;

        // 3-- 前后缀
//        int[] premax = new int[height.length];
//        premax[0] = height[0];
//        int[] backmax = new int[height.length];
//        backmax[height.length - 1] = height[height.length - 1];
//        for (int i = 1; i < height.length; i++) {
//            premax[i] = Math.max(height[i], premax[i - 1]);
//        }
//        for(int i = height.length - 2; i >= 0; i--) {
//            backmax[i] = Math.max(height[i], backmax[i + 1]);
//        }
//        int res=0;
//        for(int i=1; i<height.length-1; i++){
//            res+=Math.min(backmax[i], premax[i])-height[i];
//        }
//        return res;

        // 4 -- 双指针（广告牌）
        int res=0;
        int firstindex=0;int secondindex=height.length-1;
        int premax=height[firstindex];
        int backmax=height[secondindex];
        while(firstindex<secondindex){
            premax=Math.max(premax,height[firstindex]);
            backmax=Math.max(backmax,height[secondindex]);
            if(premax>backmax){
                res+=backmax-height[secondindex];
                secondindex--;
            }else{
                res+=premax-height[firstindex];
                firstindex++;
            }
        }
        return res;
    }
}
