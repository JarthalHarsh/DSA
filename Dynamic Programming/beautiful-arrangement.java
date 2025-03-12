//https://leetcode.com/problems/beautiful-arrangement/

class Solution {
    int count = 0;
    public void countPerms(int i,int j,int[][] dp, int n,int[] visited)
    {
       if(j == n)
       {
        count++;
        return;
       }
       visited[i] = 1;
       for(int r = 1; r<=n; r++)
       {
        if(r!=i && visited[r] == 0 && dp[r][j+1] ==1)
        {
            countPerms(r,j+1,dp,n,visited);
        }
       }
       visited[i] = 0;
    }
    public int countArrangement(int n) {
        int[][] dp = new int[n+1][n+1];
       for(int j = 1; j<=n; j++)
        {
            for(int i = 1; i<=n; i++)
        {
             if(i%j != 0 && j%i!=0)
             {
                dp[i][j] = 0;
             }
             else
             {
                dp[i][j] = 1;
             }
        }
        }
        for(int i = 1; i<=n; i++)
        {
           countPerms(i,1,dp,n,new int[n+1]);
        }
        
        return count;

    }
}