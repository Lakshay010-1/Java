package Random;
import java.util.Scanner;

class maxretryreached extends Exception{

    public String toString() {
        return "exceeeded tries";
    }

    public String getMessage() {
        return "exceeeded tries";
    }
}

public class Excep_01 {
    public static void main(String[] args) {
        int[] marks={23,4,5,6,7,5};
        int i=0;
        int num;
        boolean sit=true;
        while(i<5 && sit){
             try{ System.out.println("enter index num");
              Scanner sc=new Scanner(System.in);
               num=sc.nextInt();
               System.out.println(marks[num]);
             sit=false;}
            catch(Exception e ) {
                System.out.println("Exception");
                i++;
          } }
        try {if(i>=5){
            try{
                throw new maxretryreached();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("ERROR");}
    }catch(Exception e){
            System.out.println(e);
        }

        }}
           
