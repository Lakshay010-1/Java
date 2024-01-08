package Random;
public class Diagonal_sum {
    //optimisted approach
    public static int diagonalsum(int[][] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
            if(i!=arr.length-1-i){
                sum+=arr[i][arr.length-1-i];
            }
        }
        return sum;

        /*  Brute force OR non-optimisted approach
         public static int diagonalsum(int[][] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==j){
                    sum+=arr[i][j];
                }
                else if(i!=j){
                    if(i+j==arr.length-1){
                    sum+=arr[i][j];
                }}
            }
        }
        return sum;
    }*/

}
    public static void main(String[] args) {
        int[][] abc={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalsum(abc));
    }
}
