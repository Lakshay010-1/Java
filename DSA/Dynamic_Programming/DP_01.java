package Dynamic_Programming;
import java.util.Arrays;

//fibonacci series
public class DP_01{   
    //brute force approach ~ TC- 0(2^n)
    //DP approach ~ TC-0(n) & SC ~ 0(n)
    // 1.Memoization
    public static int fibMemo(int n,int dp[]){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]==-1){
            dp[n]=fibMemo(n-1,dp)+fibMemo(n-2,dp);
        }
        return dp[n];
    }
    // 2.Tabulation
    public static int fibTab(int n){
        int dp[]=new int[n+1];
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=10;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("Memoization -> "+fibMemo(n, dp));
        System.out.println("Tabulation -> "+fibTab(n));        
    }
}