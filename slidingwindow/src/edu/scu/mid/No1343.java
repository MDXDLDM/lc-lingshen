package edu.scu.mid;

public class No1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int sum = 0;
        int beginindex=0;
        int endindex=0;
        for (; endindex < k; endindex++) {
            sum += arr[endindex];
        }
        if(sum>=threshold*k)result++;
        for(;endindex<arr.length;){
            sum -= arr[beginindex++];
            sum += arr[endindex++];
            if(sum>=threshold*k)result++;
        }
        return result;
    }
}
