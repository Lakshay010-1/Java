package Dynamic_Programming;

//knapsack
public class DP_02 {
    //(i). 0/1 knapsack
    //Approach-1. Recursion ~ TC-0(2^n)
    public static int knapsack01(int val[],int wt[],int W,int n){
        if(n==0 || W==0){
            return 0;
        }
        //valid
        if(wt[n-1]<=W){
            //include
            int a=val[n-1]+knapsack01(val, wt, W-wt[n-1],n-1);
            //exclude
            int b=knapsack01(val, wt, W,n-1);
            return Math.max(a,b);
        }
        //un-valid
        else{
            //exclude
            return knapsack01(val, wt, W, n-1);
        }
    }
    //Approach-2. DP (Memoization) ~ TC -0(N*W)
    public static int knapsackMemo(int val[],int wt[],int W,int n,int dp[][]){
        //base case
        if(W==0 || n==0){
            return 0;
        }

        if(dp[n][W]==-1){
            //valid
            if(wt[n-1]<=W){
                dp[n][W]=Math.max(val[n-1]+knapsackMemo(val, wt, W-wt[n-1], n-1, dp),knapsackMemo(val, wt, W, n-1, dp));
            }
            //invalid
            else{
                dp[n][W]=knapsackMemo(val, wt, W, n-1, dp);
            }
        }
        return dp[n][W];
    }
    //Appeoach-3. DP(Tabulation) ~ TC-0(N*W)
    public static int knapsackTab(int val[],int wt[],int W){
        int N=val.length;
        int dp[][]=new int[N+1][W+1];
        //Assigning '0' to 0th column        
        for(int i=0;i<N+1;i++){
            dp[i][0]=0;
        }
        //Assigning '0' to 0th row
        for(int j=0;j<W+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                //valid
                if(w<=j){
                    //Maximum value between including an item or excluding an item
                    dp[i][j]=Math.max(v+dp[i-1][j-w],dp[i-1][j]);
                }
                //invalid
                else{
                    //excluding an item
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    //(ii). Unbounded knapsack
    //DP(Tabulation) ~ TC-0(N*W)
    public static int unboundedKnapsack(int val[],int wt[],int W){
        int N=val.length;
        int dp[][]=new int[N+1][W+1];
        //Assigning '0' to 0th column
        for(int i=0;i<N+1;i++){
            dp[i][0]=0;
        }
        //Assigning '0' to 0th row
        for(int j=0;j<W+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                //valid
                if(w<=j){
                    //Maximum value between including an item or excluding an item
                    dp[i][j]=Math.max(v+dp[i][j-w],dp[i-1][j]);
                }
                //invalid
                else{
                    //excluding an item
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int W=7;
        int wt[]={2,5,1,3,4};
        int val[]={15,14,10,45,30};
        int n=val.length;

        System.out.println("recursion -> "+knapsack01(val, wt, W, n));

        int dp[][]=new int[n+1][W+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        System.out.println("Memoization -> "+knapsackMemo(val, wt, W, n, dp));

        System.out.println("Tabulation -> "+knapsackTab(val, wt, W));        

        System.out.println("Unbounded Knapsack -> "+unboundedKnapsack(val, wt, W));
    }
}
