//https://leetcode.com/problems/house-robber-ii/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
        {
            return nums[0];
        }
        int[][] dp = new int[2][n];

        dp[0][n-1] = 0; //Not robbing the last house
        dp[1][n-1] = 0;
        for(int i = n-2; i>=0; i--)
        {
            dp[0][i] = nums[i] + dp[1][i+1];
            dp[1][i] = Math.max(dp[0][i+1],dp[1][i+1]);
        }
        int profitNoBuyLastHouse = Math.max(dp[0][0],dp[1][1]);
        
        dp[0][n-1] = nums[n-1]; //Robbing the last house
        dp[1][n-1] = 0;
        for(int i = n-2; i>=0; i--)
        {
            dp[0][i] = nums[i] + dp[1][i+1];
            dp[1][i] = Math.max(dp[0][i+1],dp[1][i+1]);
        }
        int profitBuyLastHouse = dp[1][0];

        return Math.max(profitNoBuyLastHouse,profitBuyLastHouse);
    }
}