package Other_Topics;

class Patterns{

    public static void printPalindromicNumberPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i)*2;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            for(int j=2;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        
    }    

    public static void printNumberPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        
    }

    public static void printDiamond(int n){
        for(int i=1;i<=n/2;i++){
            for(int j=1;j<(n/2)-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n/2;i>=1;i--){
            for(int j=1;j<(n/2)-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printHollowRhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1 || j==n || j==1 || i==n ){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
    }

    public static void printRhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
            
        }
        

    }

    public static void printButterfly(int n){
        for(int i=1;i<=n/2;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-(2*i);j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n/2;i>=1;i--){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=0;j<n-(2*i);j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printZeroOnePyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if((i+j)%2==0){
                    System.out.print("1");
                }
                else{System.out.print("0");}
            }
            System.out.println();
        }
    }

    public static void printFloydHalfPyramid(int n){
         int a=1;
         for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print(a +" ");
                a++;
            }
            System.out.println();
         }
    }

    public static void printInvertedNumberHalfPyramid(int n){
        for(int i=0;i<n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void printInvertedAndRotatedHalfPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
                }
            for(int j=0;j<i;j++){
                    System.out.print("*");
                }
            System.out.println(); 

        }
    }


    public static void printHollowRectangle(int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==row-1 || i==0 || j==0 || j==col-1){
                    System.out.print("*");
                }
                else{System.out.print(" ");}
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        //Write a program that reads a set of integers, and then prints the sum of the even and odd integers.
        /* 
        Scanner sc = new Scanner(System.in);
        int number, choice,evenSum = 0, oddSum = 0;
        
        do {
            System.out.print("Enter the number ");
            number = sc.nextInt();
            if( number % 2 == 0) {
                evenSum += number;
                }
            else {
                oddSum += number;
                }
            System.out.print("Do you want to continue? Press 1 for yes or 0 for no");
            choice = sc.nextInt();
            } while(choice==1);
            
            System.out.println("Sum of even numbers: " + evenSum);
            System.out.println("Sum of odd numbers: " + oddSum);
         */
        printPalindromicNumberPyramid(8);
}
}
