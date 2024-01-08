package Array;

public class array_02 {
    public static void print2dArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    
    //diagonal sum
    public static int diagonalSum(int arr[][]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            count+=arr[i][i];
            if(i!=arr.length-i-1){
                count+=arr[i][arr.length-1-i];
            }
        }
        return count;
    }

    
    //search in sorted 2d array
    public static boolean searchin2d(int arr[][],int target){
        int row=0,col=arr[0].length-1;

        while(row<arr.length && col>=0){
            if(arr[row][col]==target){
                System.out.println("found at "+row+" "+col+" in the matrix");
                return true;
            }
            else if(arr[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
   

    //write a transpose of an array
    public static void transposeMatrix(int arr[][]){
        int n=arr.length,m=arr[0].length;
        int temp[][]=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[j][i]=arr[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=temp[i][j];
            }
        }
    }

    // print spiral matrix
    public static void printSpiralMatrix(int arr[][]){
        int startRow=0,startCol=0,endRow=arr.length-1,endCol=arr[0].length-1;
        while(startRow<=endRow && startCol<=endCol){
            //up
            for(int i=startCol;i<=endCol;i++){
                System.out.print(arr[startRow][i]+" ");
            }
            startRow++;
            //right
            for(int i=startRow;i<=endRow;i++){
                System.out.print(arr[i][endCol]+" ");
            }
            endCol--;

            //down
            for(int i=endCol;i>=startCol;i--){
                System.out.print(arr[endRow][i]+" ");
            }
            endRow--;
            //left
            for(int i=endRow;i>startCol;i--){
                System.out.print(arr[i][startCol]+" ");
            }
            
            startCol++;
            
            
            

        }
    }

    public static void main(String[] args) {
        int arr[][]= {{1,2,1},{4,1,6},{1,8,1}};
        
        
    }    
}
