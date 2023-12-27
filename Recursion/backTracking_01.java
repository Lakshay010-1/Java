public class backTracking_01 {

    //Sudoku
    public static boolean sudokuSolver(int sudoku[][],int row,int col){
        if(row==sudoku.length && col==0){
            return true;
        }
        int nextRow=row,nextCol=col+1;
        if(col+1==sudoku[0].length){
            nextRow=row+1;
            nextCol=0;
        }

        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        
        for(int i=1;i<=9;i++){
            if(isPlaceSafe(sudoku,row,col,i)){
                sudoku[row][col]=i;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }            
        }
     
     return false;

    }

    public static boolean isPlaceSafe(int sudoku[][],int row,int col,int digit){
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        for(int j=0;j<sudoku[0].length;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }
        int openingGridRow=(row/3)*3;
        int opeingGridCol=(col/3)*3;
        for(int i=openingGridRow;i<openingGridRow+3;i++){
            for(int j=opeingGridCol;j<opeingGridCol+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

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

    //nQueens;time complexity=0(n!)
    public static void nQueens(char board[][],int row){
        if(row==board.length){
            //printBoard(board);
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i]='Q';
                nQueens(board,row+1);
                board[row][i]='.';
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

    public static void printBoard(int board[][]){
        System.out.println("-------Chess Board-------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Factorial
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
   
    public static void main(String[] args) {
    int n=3;
    /*
    char board[][]=new char[n][n];
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
            board[i][j]='.';
        }
    }
    nQueens(board, 0);  
    */
    int sudoku[][]=
    { 
        {0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}
    };
    if(sudokuSolver(sudoku, 0, 0)){
        System.out.println("solution exists");
        printBoard(sudoku);
    }
    else{
        System.out.println("no solution exists");
    }

    
    }
    
}
