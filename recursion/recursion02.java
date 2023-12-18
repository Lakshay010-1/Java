
public class recursion02 {

    //hanoi tower
    public static void hanoiTower(int n,String source,String helper,String dest){
        if(n==1){
            System.out.println("Transferring disk"+n+" from "+source+" to "+dest);
            return;
        }
        hanoiTower(n-1, source, dest, helper);
        System.out.println("Transferring disk"+n+" from "+source+" to "+dest);
        hanoiTower(n-1, helper, source, dest);
    }

    // find all the occurrences of a given element and print them
   public static void printAllIndexies(int arr[],int key,int i){
        if(arr.length==0){
            System.out.print("-1");
            return ;
        }
        if(i==arr.length){return;}
        if(arr[i]==key){
            System.out.print(i+" ");
        }
        printAllIndexies(arr, key, i+1);
   }

   //You are given a number, convert it into a String of english 
   public static void convertToString(int n){
    if(n<=0){return;}
    String[] engNum={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    int lastDigit=n%10;
    n/=10;
    convertToString(n);
    System.out.print(engNum[lastDigit]+" ");

   }

   //ind the count of all contiguous substrings starting and ending with the same character
   public static int totalConSubstr(String str, int i, int j, int n) {
    if (n == 1) {
    return 1;
    }
    if (n <= 0) {
    return 0;
    }
    int res = totalConSubstr(str, i + 1, j, n - 1) +totalConSubstr(str, i, j - 1, n - 1) -totalConSubstr(str, i + 1, j - 1, n - 2);
    if (str.charAt(i) == str.charAt(j)) {
    res++;
    }
    
    return res;
}
public static void main(String[] args) {
    int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
    int key = 2;
    String str="abcab";
    int n=str.length();
    hanoiTower(3, "S", "H", "D");

}
    
}