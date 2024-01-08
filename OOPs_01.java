
//packages is a group of similiar types of classes,interfaces,and sub-packages.

//Abstraction
//abstract classes
abstract class plants{
    String color;
    plants(){
        color="green";
    }
    void nature(){
        System.out.println("environment friendly in nature");
    }
    abstract void growingEnvironment();

}
class cactus extends plants{
    @Override
    void growingEnvironment() {
        System.out.println("grows in both sand and soil");
    }
}

//Interfaces
interface animal{
    void sleep();
}
interface LivingBeings{
    void walks();
    void eats();
}
class human implements LivingBeings,animal{
    public void sleep(){
        System.out.println("sleep");
    }
    public void walks(){
        System.out.println("walks on 2 legs");
    }
    public void eats(){
        System.out.println("eats food");
    }
}

//Polymorphism
class oldCalculator{
    int product(int a,int b){
        return a*b;
    }
}
class Calculator extends oldCalculator {
    //Compile time polymorphism(Method Overloading)
    int sum(int a,int b){
        return a+b;
    }
    int sum(float a,float b){
        return (int)(a+b);
    }
    int sum(int a,int b,int...c){
        int sum=a+b;
        for(int e:c){
            sum+=e;
        }
        return sum;
    }

    //Run time polymorphism(Method Over-riding)
    @Override
    int product(int a,int b){
        System.out.println("product is equal to =");
        return a*b;
    }



    
}

class Animals{
    Animals(){
        System.out.println("animals constructor is called");
    }
    void eats(){
        System.out.println("eats food");
    }
    void walks(){
        System.out.println("walks on 4 legs");
    }
}

//Inheritence 
class Lion extends Animals{
    Lion(){
        System.out.println("lion constructor is called");
    }
    @Override
    void eats(){
        System.out.println("lion eats other animals by hunting them");
    }
    void nature(){
        System.out.println("king of the jungle");
    }
}

class Students{
    int roll;
    String Name;
    private int uniqueCode;
    static String school;
    //------>Constructors
    //non parameterized constructors
    Students(){
        System.out.println("students constructor is called");
    }
    //parameterized constructors
    Students(String Name,int roll){
        this.Name=Name;
        this.roll=roll;
    }
    //copy constructors
    Students(Students s){
        this.Name=s.Name;
        this.roll=s.roll;
    }
    
    //getters and setters
    public void setCode(int code){
         this.uniqueCode=code;
     }
     public int getCode(){
        return this.uniqueCode;
     }
     void setName(String Name){
        this.Name=Name;
    }
    void setRoll(int roll){
        this.roll=roll;
    }    
      

}

//Encapsulation
class Complex {
    int realNum;
    int imagNum;
    Complex(int realNum,int imagNum){
        this.realNum=realNum;
        this.imagNum=imagNum;
    }
    public Complex addComplex(Complex a,Complex b){
        return new Complex((a.realNum+b.realNum),(a.imagNum+b.imagNum));
    }

    public Complex subComplex(Complex a,Complex b){
        return new Complex((a.realNum-b.realNum),(a.imagNum-b.imagNum) );
    }

    public Complex productComplex(Complex a,Complex b){
        return new Complex((a.realNum*b.realNum)-(a.imagNum*b.imagNum),(a.realNum*b.imagNum)+(a.imagNum*b.realNum));

    }

    public void printComplex(){
        if(realNum==0 && imagNum!=0){
            System.out.println(imagNum+"i ");
        }
        else if( imagNum==0 && realNum!=0){
            System.out.println(realNum+"r ");
        }
        else{
            System.out.println(realNum+"r "+imagNum+"i ");
        }
    }

    
    
}

public class OOPs_01 {
    public static void main(String[] args) {
        /*
         * Print the sum, difference and product of two complex numbers by creating a
         * class named 'Complex' with separate methods for each operation whose real and
         * imaginary parts are entered by the user
         */
       /*
        Complex c = new Complex(3,2);
        Complex cp = new Complex(2,3);

        Complex x=c.addComplex(c, cp);
        Complex y=c.subComplex(c, cp);
        Complex z=c.productComplex(c, cp);

        x.printComplex();
        y.printComplex();
        z.printComplex();
       */

      /* 
        Students.school="MIT";
        Students s1=new Students();
        s1.setName("LKG");
        s1.setRoll(21);
        System.out.println(s1.school); 
        s1.school="XYZ";       
        System.out.println(s1.Name);
        System.out.println(s1.roll);
        s1.setCode(3456778);
        System.out.println(s1.getCode());
        Students s2=new Students(s1);
        System.out.println(s2.Name);
        System.out.println(s2.roll);
        System.out.println(s2.school);
      */
       
      
        //object intialisation
        /*object intitlised in it's own class  ---->  allowed */
        //Animals an=new Animals();
        //Lion lk=new Lion();

        /*object intialised in paraent's reference  ---->  allowed */
        //Animals anlk =new Lion();
        
        /*object intialised in derived class reference ----> Not allowed */
        //Lion lkan=new Animals(); 
        //lk.eats();
        //lk.walks();
        //lk.nature();



        
        

    }

}
