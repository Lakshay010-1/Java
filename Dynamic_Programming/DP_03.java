package Dynamic_Programming;

//Longest Common SubSequence
public class DP_03 {
    //recursion ~ TC-0(2^n+m)
    public static int lcs(String str1,int n,String str2,int m){
        if(n==0 || m==0){
            return 0;
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)){
            return lcs(str1,n-1,str2,m-1)+1;
        }
        else{
            return Math.max(lcs(str1,n-1,str2,m),lcs(str1,n,str2,m-1));
        }
    }
    //DP (Memoization) ~ TC-0(n*m)
    public static int lcsMemo(String str1,int n,String str2,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]==-1){
            if(str1.charAt(n-1)==str2.charAt(m-1)){
                dp[n][m]=lcsMemo(str1, n-1, str2, m-1, dp)+1;
            }else{
                dp[n][m]=Math.max(lcsMemo(str1, n-1, str2, m, dp),lcsMemo(str1, n, str2, m-1, dp));
            }
        }
        return dp[n][m];
    }
    //DP (Tabulation)) ~ TC-0(n*m)
    public static int lcsTab(String str1,String str2){
        int n=str1.length(),m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1="abcd";
        String str2="aefcd";
        int n=str1.length(),m=str2.length();        
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    continue;
                }
                dp[i][j]=-1;
            }
        }
        System.out.println("recursion -> "+lcs(str1, n, str2, m));
        System.out.println("DP(Memoization) -> "+lcsMemo(str1, n, str2, m, dp));
        System.out.println("DP(Tabulation) -> "+lcsTab(str1, str2));
    }
}
