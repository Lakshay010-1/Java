package Dynamic_Programming;
import java.util.Arrays;

//Matrix(Matrix Chain Multiplication)
public class DP_05 {
    // Approach-1.Recursion ~ TC-0(n^n)
    public static int mcm(int arr[], int start, int end) {
        if (start == end) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            int c1 = mcm(arr, start, k);
            int c2 = mcm(arr, k + 1, end);
            int c3 = arr[start - 1] * arr[k] * arr[end];
            int finalCost = c1 + c2 + c3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

    // Approach-2.DP(Memoization) ~ TC-0(n^3)
    public static int mcmMemo(int arr[], int start, int end, int dp[][]) {
        if (start == end) {
            return 0;
        }
        if(dp[start][end]==-1){
            int ans = Integer.MAX_VALUE;
            for (int k = start; k < end; k++) {
                int c1 = mcmMemo(arr, start, k,dp);
                int c2 = mcmMemo(arr, k + 1, end,dp);
                int c3 = arr[start - 1] * arr[k] * arr[end];
                int finalCost = c1 + c2 + c3;
                ans = Math.min(ans, finalCost);
            }
            dp[start][end]=ans;
        }
        return dp[start][end];
    }

    // Approach-3.DP(Tabulation) ~ TC-0(n^3)
    public static int mcmTab(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];
        
        for(int len=2;len<n;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],(dp[i][k])+(dp[k+1][j])+(arr[i-1]*arr[k]*arr[j]));
                }
            }
        }
        return dp[1][n-1];
    }
    
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;        

        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println("recursion -> " + mcm(arr, 1, n - 1));
        System.out.println("Memoization -> "+mcmMemo(arr, 1, n-1, dp));
        System.out.println("Tabulation -> "+mcmTab(arr));
    }
}
