import java.util.HashSet;

public class recursion02 {

    //print all possible combinations of a keypad number characters~0(4^n)
    public static void printKeypadComb(String Keypad[],String str,int idx,String combination){
        if(idx==str.length()){
            System.out.println(combination);
            return;
        }
        char currChar=str.charAt(idx);
        String map=Keypad[currChar-'0'];
        for(int i=0;i<map.length();i++){
            char comb=map.charAt(i);
            printKeypadComb(Keypad, str, idx+1, combination+comb);

        }
    }

    //print all the unique subsequences of a string ~ 0(2^n)
    public static void allSubseq(String str,int idx,String newstr,HashSet<String> set){
        if(idx==str.length()){
            if(set.contains(newstr)){
                return;
            }
            System.out.println(newstr);
            set.add(newstr);
            return;
        }
        char currChar=str.charAt(idx);
        
        allSubseq(str, idx+1, newstr+currChar,set);
        allSubseq(str, idx+1, newstr,set);
        

    }

    //move a particular element to the end of the string
    public static String moveCharLast(String str,char key,int idx,StringBuilder newStr1,StringBuilder newStr2) {
        if(idx==str.length()){
            return (newStr1.append(newStr2)).toString();
        }
        char currChar=str.charAt(idx);
        if(currChar==key){
            newStr2.append(currChar);
        }else{
            newStr1.append(currChar);
        }
        return moveCharLast(str, key, idx+1, newStr1, newStr2);
    }

    //check if an array is strictly increasing or not
    public static boolean isStrictSorted(int arr[],int idx){
        if(idx==arr.length-1){
            return true;
        }
        boolean isSorted= arr[idx] < arr[idx+1] && isStrictSorted(arr, idx+1);
        return isSorted;
    }

    //find first and last occurence of key in a String together ~ 0(n)
    static int first=-1;
    static int last=-1;
    public static void firLastOccu(String str,int idx,char key){
        if(idx==str.length()){
            System.out.println("First Occurence = "+first);
            System.out.println("Last Occurence = "+last);
            return;
        }
        char currChar=str.charAt(idx);
        if(currChar==key){
            if(first==-1){
                first=idx;
            }
            else{
                last=idx;
            }
        }
        firLastOccu(str, idx+1, key);
    }

    //print a string in reverse
    //optimised approach
    public static void revString(String str,int idx){
        if(str.length()==0||idx==0){
            System.out.print(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        revString(str, idx-1);
    }

    //un-optimised approach
    /*public static String revString(String str){
        if(str.length()==0){
            return "";
        }
        String newStr="";
        newStr+=str.charAt(str.length()-1)+revString(str.substring(0, str.length()-1));
        return newStr;
    }*/ 

    //hanoi tower ~ 0(2^n-1)~0(2^n)
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
    int arr[] = {1,2,3,4,5,5};
    int key = 2;
    String str="aaa";
    StringBuilder str1=new StringBuilder();
    StringBuilder str2=new StringBuilder();
    HashSet<String> set=new HashSet<>();
    String keypad[]={".", "abc", "def", "ghi", "jkl", "mno", "pqrs","tu", "vwx", "yz"};
    String num="23";
    printKeypadComb(keypad, num, 0, "");

       
}
    
}
