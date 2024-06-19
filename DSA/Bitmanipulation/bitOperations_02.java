import java.util.*;

public class bitOperations_02{
    public static void main(String[] args) {
// get bit 
        System.out.println("get bit operation");
        int n1 = 5; 
        int pos1 = 3;
        int bitMask1 = 1<<pos1;
  
  
        if((bitMask1 & n1) == 0) {
            System.out.println("bit was zero");
        } else {
            System.out.println("bit was one");
        }
        System.out.println();
  
 //set bit
      System.out.println("set bit operation");

        int n2 = 5; //0101
      int pos2 = 1;
      int bitMask2 = 1<<pos2;


      int newNumber = bitMask2 | n2;
      System.out.println(newNumber);
      System.out.println();

//clear bit
        System.out.println("clear bit operation");

      int n3 = 5; //0101
      int pos3 = 2;
      int bitMask3 = 1<<pos3;
      int newBitMask = ~(bitMask3);
      int new_Number = newBitMask & n3;
      System.out.println(new_Number);
      System.out.println();

//update bit
        System.out.println("update bit operation");
        Scanner sc = new Scanner(System.in);
       int oper = sc.nextInt();
       // oper=1 -> set bit operation ; oper=0 -> clear bit operation
      int n4 = 5;
      int pos4 = 1;
     
      int bitMask4 = 1<<pos4;
      if(oper == 1) {
          //set
          int neewNumber = bitMask4 | n4;
          System.out.println(neewNumber);
      } else {
       //clear
       int new_BitMask = ~(bitMask4);
       int newwNumber = new_BitMask & n4;
       System.out.println(newwNumber);
      }

    }

}