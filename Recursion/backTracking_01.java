
public class backTracking_01 {

    //find no. of ways to reach from (0,0) to (n-1,m-1) in a n*m grid.{Limitation:-allowed moves=right and down}
    //Approach no. 1;Time complexity=0(2^(n+m))
    public static int countGridMoves(int i,int j,int n,int m){
        if(i==n-1 || j== m-1){
            return 1;
        }
        else if(i==n || j== m){
            return 0;
        }
        int count=countGridMoves(i+1, j, n, m)+countGridMoves(i, j+1, n, m);
        return count;
    }
    //Approach no.2;Time complexity=0(n+m)
    public static int countGridMovesOptimised(int n,int m){
        int numerator=factorial(n-1+m-1);
        int denom=factorial(n-1)*factorial(m-1);
        return numerator/denom;
    }
    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        int fac=n*factorial(n-1);
        return fac;
    }     

      //print all subSets of a string; time complexity=0(n*2^n)
      public static void printSubset(String str,String Subset,int i){
        if(i==str.length()){
            System.out.println(Subset);
            return;
        }
        printSubset(str, Subset+str.charAt(i), i+1);
        printSubset(str, Subset, i+1);
     }

    //print all permutation of a string; time complexity=0(n*n!)
    public static  void printPerm(String str,String newStr){
        if(str.length()==0){
            System.out.println(newStr);
            return;
        }
        for(int i=0;i<str.length();i++){
            char currChar=str.charAt(i);
            printPerm(str.substring(0, i)+str.substring(i+1), newStr+currChar);
        }
            
    }
   
    //nQueens;time complexity=0(n!)
    public static void nQueens(char board[][],int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                nQueens(board,row+1);
                board[row][col]='.';
            }
        }
    }

    public static boolean isSafe(char board[][],int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
                }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char board[][]){
        System.out.println("-------Chess Board-------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
    int n=4;
    char board[][]=new char[n][n];
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
            board[i][j]='.';
        }
    }
    nQueens(board, 0);  
    
    }


    
}
