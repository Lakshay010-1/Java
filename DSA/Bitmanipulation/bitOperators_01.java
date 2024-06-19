import java.util.*;

public class bitOperators_01 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Either enter 1 or 0 to ");
        System.out.println("Enter num01");
        int a=sc.nextInt(2);
        System.out.println("Enter num02");
        int b=sc.nextInt(2);
        if(a<0 || b<0){
            return;
        }

//And operator(&)
        System.out.print("bit wise AND operator=");
        int andOperator =a&b;
        System.out.println(andOperator);   

//or operator(|)
        System.out.print("bit wise OR operator=");
        int orOperator=a|b;
        System.out.println(orOperator);

//not Or operator(^)
        System.out.print("bit wise XOR operator=");
        int xorOperator=a|b;
        System.out.println(xorOperator);

        System.out.println("Enter any number in binary");
        int c=sc.nextInt();
        System.out.println("By how many bits you want to move the binary number");
        int d=sc.nextInt();

//binary left shift operator(<<)
        System.out.print("binary left shift operator=");
        int leftOperator=c<<d;
        System.out.println(leftOperator);

//binary right shift operator(>>)
        System.out.print("binary right shift operator=");
        int rightOperator=c<<d;
        System.out.println(rightOperator);

        System.out.println("enter number you want complement of in binary");
        int e=sc.nextInt();
        
//complement operator(~)
        System.out.println((~e));
    }
    
}
