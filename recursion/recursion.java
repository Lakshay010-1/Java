class recursion{
    //print binary string without consectives 1s
    public static void withOutConsectivesOnes(int n,int lastPlace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }          
        withOutConsectivesOnes(n-1, 0, str+"0");
        if(lastPlace==0){
            withOutConsectivesOnes(n-1, 1, str+"1");
        }                      
    }

    //total ways of pairing n friends
    public static int friendsPairing(int n){
        if(n==1||n==2||n==0){
            return n;
        }
        //single
        int way1=friendsPairing(n-1);
        //pairing
        int way2=(n-1)*friendsPairing(n-2);
        return way1+way2;
    }

    //remove duplicate from the string
    public static String removeDuplicate(String str,StringBuilder newStr,int i,boolean track[]){
        if(i==str.length()){
            return "";
        }
        char currchar=str.charAt(i);
        if(track[currchar-'a']==true){
            removeDuplicate(str, newStr, i+1, track);
        } else{
            track[currchar-'a']=true;
            removeDuplicate(str, newStr.append(currchar), i+1, track);
        }
        return newStr.toString();

    }

    //find number of ways to fill a 2*n size floor with 2*1 tile
        public static int totalTileWays(int n){
            if(n==1||n==0){
                return 1;
            }
            // putting tile tile horizontally 
            int way1=totalTileWays(n-1);
            // putting tile tile horizontally 
            int way2=totalTileWays(n-2);
            int totalWays=way1+way2;
            return totalWays;
        
        }
     
    // find x to the power of n 
    public static int power(int x,int n){
        
        // find x to the power of n ;TC-0(logn)
        if(n==0){
            return 1;
        }
        if(n%2==1){
            return x*power(x,n-1);
        }

        int half_Res=power(x,n/2);            
        int res=half_Res*half_Res;
        
        return res;

        //find x to the power of n ;TC-0(n)
        /*
            if(n==0){
            return 1;
        }
        
        return x*power(x,n-1) ;
        */
    }

    //last occurence of an element in an array
    public static int lastOcc(int arr[],int key,int i){
        // this approach is useful when i is given from starting index.
        if(i==arr.length){
            return -1;
        }
        int isFound=lastOcc(arr, key, i+1);
        if(isFound==-1&&arr[i]==key){
            return i;
        }
        return isFound;

        /*
        this approach is useful when i is given from the last index.
        if(i<0){
            return -1;
        }       
        if(arr[i]==key){
            return i;
        }
        return lastOcc(arr, key, i-1);
        */

    }
    
    //first occurence of an element in an array
    public static int firstOcc(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }       
        if(arr[i]==key){
            return i;
        }
        return firstOcc(arr, key, i+1);

    }

    //check if given array is sorted or not
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        
        boolean result=arr[i]<=arr[i+1] && isSorted(arr, i+1);
        return result;
    }

    //print nth term fibonacci number
    public static int nthFibonacci(int n){
        // 0th based indexing
        if(n==0 || n==1){
            return n;
        }
        //1 th based indexing
        /*
        if(n==1|| n==2){
            return n-1;
        } 
        */
        int num=nthFibonacci(n-1)+nthFibonacci(n-2);
        return num;
    }

    //print factorial till nth term
    public static int printfact(int n){
        if(n<0){
            return -1;
        }
        if(n==0){
            return 1;
        }
        
        int fac = n*printfact(n-1);
        return fac;
    }

    //print sum of first n natural numbers
    public static int sumNat(int n){
        if(n<1){
            return 0;
        }
        int sum = n+sumNat(n-1);
        return sum;
    }

    //print number n to 1
    public static void numNtoOne(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        numNtoOne(n-1);
    }

    //print number 1 to n
    public static void numOnetoN(int n){
        if(n==0){
            return;
        }
        numOnetoN(n-1);

        System.out.print(n+" ");
    }

    public static void main(String[] args) {
        int[] arr={5,4,3,5,7};
        int n=arr.length-1;
        String str="aaabbbbcccdddabc";
        boolean track[]=new boolean[26];
        StringBuilder newStr=new StringBuilder();
        withOutConsectivesOnes(3, 0, "");
    }
}
