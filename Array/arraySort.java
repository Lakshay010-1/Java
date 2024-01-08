package Array;

public class arraySort {
    public static void print2dArray(int arr[]){
        for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        
    }
    //0(n^2)
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

    }

    //0(n^2) 
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minpos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minpos]>arr[j]){
                    minpos=j;
                }
            }
            int temp=arr[minpos];
            arr[minpos]=arr[i];
            arr[i]=temp;

        }
    }

    //0(n^2)
    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];prev--;                
            }
            arr[prev+1]=curr;
        }
        
    }

    //0(n+range)
    public static void countingSort(int arr[]){
        int intMax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            intMax=Math.max(intMax,arr[i]);
        }
        int temp[]=new int[intMax+1];
        for(int i=0;i<arr.length;i++){
            temp[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<temp.length;i++){
            while(temp[i]!=0){
                arr[j]=i;
                j++;
                temp[i]--;
                
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={5,3,2,1};
        
        }
}
