package Array;
public class maxSubarraySum {

    //brute force approach ;TC-0(n^3)
    public static int maxSubArraySum(int arr[]){
        int count=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                count=0;
                System.out.print("(");
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]);
                    count+=arr[k];
                }
                System.out.println(") = "+ count);
                maxSum=Math.max(count,maxSum);
            }
        } 
        return maxSum;       
    }
    
    //prefix sum;TC-0(n^2)
    public static int prefixSum(int arr[]){
        int maxSum=Integer.MIN_VALUE,currSum;
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=arr[i]+prefix[i-1];
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                currSum= i==0?prefix[j]:prefix[j]-prefix[i-1];
                maxSum=Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    //kadane's approach ;TC-0(n)
    public static int kadaneSum(int arr[]){
         int maxSum=Integer.MIN_VALUE,currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum=Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[]={1,-8,0,16589,9};
        System.out.println(prefixSum(arr));
        System.out.println(kadaneSum(arr));
        
    }
    
}
