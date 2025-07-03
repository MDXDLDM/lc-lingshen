package edu.scu.part3;

public class No1449 {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int k = 1; k <= 9; k++) {
            int value = cost[k - 1];
            String l = String.valueOf(k);
            for (int i = value; i <= target; i++) {
                if (dp[i - value] != null) {
                    String temp = l + dp[i - value];
                    if (dp[i] == null) {
                        dp[i] = temp;
                    } else {
                        if (temp.length() > dp[i].length()) {
                            dp[i] = temp;
                        } else if (temp.length() == dp[i].length()) {
                            for (int j = 0; j < temp.length(); j++) {
                                if (dp[i].charAt(j) == temp.charAt(j)) continue;
                                if (dp[i].charAt(j) < temp.charAt(j)) dp[i] = temp;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[target] == null ? "0" : dp[target];
    }
}
