import java.util.Scanner;
import java.util.Random;

// rock paper scissor game
public class project_02 {
    public static void main(String[] args) {
    String p = "paper";
    String r = "rock";
    String s = "scissor";

        System.out.println("0=Paper\n1=Rock\n2=Scissor");


        Scanner scn = new Scanner(System.in);
        System.out.println("enter your number(0/1/2)");
       try{
        int a = scn.nextInt(3);
        char hb = (char)( a+'q');
        switch(hb){
            case 'q'-> System.out.println("you choose "+p);
            case 'r'-> System.out.println("you choose "+r);
            case 's'-> System.out.println("you choose "+s);

        }

    Random rn = new Random();
        int b =rn.nextInt(3);
    char com = (char) (b+'q');

    switch(com){
        case 'q'-> System.out.println("computer choose "+p);
        case 'r'-> System.out.println("computer choose "+r);
        case 's'-> System.out.println("computer choose "+s);

    }
    if(a==b){
        System.out.println("your match is draw");
    }
    else if(a==0 ){
     if(b==1){
         System.out.println("you win ");
        }
     else if(b==2){
         System.out.println("you lose");
     } }
    else if(a==1 ){
        if(b==0){
            System.out.println("you lose");
        }
        else if(b==2){
            System.out.println("you win");
        } }
    else if(a==2 ){
        if(b==1){
            System.out.println("you lose");
        }
        else if(b==0){
            System.out.println("you win");
        } }
}
catch(Exception e){
    System.out.println("Significant Move");
}
}}
