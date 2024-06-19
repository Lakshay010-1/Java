import java.util.*;

//Sudoku
public class project_04 {

    public static int[][] enterBoard(){
        int board[][]=new int[9][9];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                System.out.println("Enter value at index "+i+" : "+j);
                try{
                    board[i][j]=sc.nextInt(10);
                }
                catch(Exception e){
                    System.out.println("inaccurate Input");
                }
                System.out.println();
            }
        }
        return board;
    }

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

    public static void printBoard(int board[][]){
        System.out.println("-------Sudoku Board-------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

  
    public static void main(String[] args) {    

    //0 represents empty places.
    
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
    //int sudoku[][]=enterBoard();
    if(sudokuSolver(sudoku, 0, 0)){
        System.out.println("solution exists");
        printBoard(sudoku);
    }
    else{
        System.out.println("no solution exists");
    }

    
    }
    
}
