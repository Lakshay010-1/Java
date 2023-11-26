package com.chetancodes;
import java.util.Scanner;

class Mixture{

    public static void printSpiral(int[][] arr){
        int startRow=0;
        int endRow=arr.length-1;
        int endCol=arr.length-1;
        int startCol=0;
        while(startRow<=endRow && startCol<=endCol){
            for(int i=startCol;i<endCol;i++) {
                System.out.print(arr[startRow][i]+" ");
            }
            for(int i=startRow;i<endRow;i++){
                System.out.print(arr[i][endCol]+" ");

            }
            for(int i=endCol;i>startCol;i--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(arr[endRow][i]+" ");
            }
            for(int i=endRow;i>startRow;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(arr[i][startCol]+" ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

    }
    
    public static void kadaneSort(int[] arr){
    int max=Integer.MIN_VALUE;
    int cur = 0;
    for(int i=0;i<arr.length;i++){
        cur += arr[i];
        if(cur<0){
            cur=0;
        }
        max=Math.max(cur,max);
    }
        System.out.println(max);
    }
   
    public static void prefixSum(int[] arr){
        int max=Integer.MIN_VALUE;
        int cur=0;
        int pre[]=new int[arr.length];
        pre[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pre[i]= arr[i]+pre[i-1];
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                cur =(i==0)?pre[j]:pre[j]-pre[i-1];
                if(cur>max){
                    max=cur;
                }
            }
        }
        System.out.println(max);


    }
   
    public static void printPair(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+")"+" ");
            }
            System.out.println();
        }
    }
   
    public static void reverseArray(int arr[]){
        int start=0;
        int end=arr.length-1;
        int temp;
        while(start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        }

    public static int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int start =1;
        int end=x;
        int ans=1;
        while(start<=end){
            int mid=(start+end)/2;
            if(mid*mid<=x){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
   
    public static int trappedRainWater(int[] height,int width){
        int maxWater=0;
        int totalWater=0;
        int x=height.length;
        if(x<3){
            return 0;
        }
        int[] leftMax=new int[x];
        int[] rightMax=new int[x];
        leftMax[0]=height[0];
        for(int i=1;i<x;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        rightMax[x-1]=height[x-1];
        for(int i=x-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
            }
        for(int i=0;i<x;i++){
            int WaterLevel=Math.min(rightMax[i],leftMax[i]);
            int waterArea=(WaterLevel-height[i])*width;
            totalWater += waterArea;
            if(waterArea>maxWater){
                maxWater=waterArea;
            }
        }
            System.out.println("max water : "+maxWater);
        return totalWater;
        }
    
    public static int maxProfit(int[] prices){
        int maxpro=0;
        int buyprice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(buyprice<prices[i]){
                int profit=prices[i]-buyprice;
                if(profit>maxpro){
                    maxpro=profit;
                }
            }else{
                buyprice=prices[i];
            }
        }
        return maxpro;
        }
    
    public static void bubbleSort(int[] arr){
            int temp;
        for (int i=0;i<arr.length-1;i++){
            int swap=0;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swap=1;
                }}
                if(swap==0){
                    System.out.println(i);
                    System.out.println("already sorted");
                    return;

            }
        }
        }
    
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int sma=i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[sma]){
                    sma=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[sma];
            arr[sma]=temp;
        }
        }
   
    public static void insertionSort(int[] arr){
        for(int i=1;i< arr.length;i++){
            int cur=arr[i];
            int pre=i-1;
            while(pre>=0&&arr[pre]>cur){
                arr[pre+1]=arr[pre];
                pre--;
            }
            arr[pre+1]=cur;
        }
        }
    
    public static void countingSort(int[] arr){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
                largest=Math.max(largest,arr[i]);

        }
        int[] count=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }

        }
        }

    public static void main(String[] args) {
           
       }
    }
