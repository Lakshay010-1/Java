package Dynamic_Programming;
import java.util.Arrays;

//Catalan Numbers
public class DP_04 {
    
    //Approach-1. Recursion ~ TC-0(n^n)
    public static int cat(int n){
        if(n==0|| n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=cat(i)*cat(n-1-i);
        }
        return ans;
    }
    //Approach-2. DP(Memoization) ~ TC-0(n^2)
    public static int catMemo(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]==-1){
            int ans=0;
            for(int i=0;i<n;i++){
                ans+=catMemo(i, dp)*catMemo(n-1-i, dp);
            }            
            dp[n]=ans;
        }
        return dp[n];
    }
    //Approach-3. DP(Tabulation) ~ TC-0(n^2)
    public static int catTab(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=10;        
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("recursion -> "+cat(n));
        System.out.println("Memoization -> "+catMemo(n, dp));
        System.out.println("Tabulation -> "+catTab(n));
        
    }
}
