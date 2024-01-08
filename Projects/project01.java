package Projects;
import java.util.Scanner;

// this percentage calculator is for 5 subjects

public class project01 {
    public static void main(String[] args) {

        System.out.println("enter your subjects marks");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your subject01 marks");
        int a = sc.nextInt();
        System.out.println("Enter your subject02 marks");
        int b = sc.nextInt();
        System.out.println("Enter your subject03 marks");
        int c = sc.nextInt();
        System.out.println("Enter your subject04 marks");
        int d = sc.nextInt();
        System.out.println("Enter your subject05 marks");
        int e = sc.nextInt();
        System.out.println("marks are out of");
        int f = sc.nextInt();

        int g = a+b+c+d+e ;
        int h = 5 * f ;
        float m = g*100.0f/ h;
        System.out.println("your % is "+ m);


 }
}
