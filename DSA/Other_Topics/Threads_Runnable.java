package Other_Topics;

class Counter{
    int count=0;
    public synchronized void increment(){
        count++;
    }
}
class A extends Thread{
    public  void run(){
        for(int i=0;i<100;i++){
            System.out.println("A show");
        }
    }
}
class B extends Thread{
    public  void run(){
        for(int i=0;i<100;i++){
            System.out.println("B ");
        }
    }
}
// class Y implements Runnable{
//     public void run(){
//         for(int i=0;i<100;i++){
//              System.out.println("Y show showing and flowing");
//          }
//     }
// }
// class Z implements Runnable{
//     public void run(){
//         for(int i=0;i<100;i++){
//              System.out.println("Z show showing");
//         }
//     }
// }

public class Threads_Runnable{
    public static void main(String[] args) {
        // A o1=new A();
        // B o2=new B();
        // o2.setPriority(Thread.MAX_PRIORITY);
        // o1.start();
        // o2.start();
        Counter c=new Counter();
        Runnable o3=() -> {
            for(int i=0;i<1000;i++){
                c.increment();
            }
        };
        Runnable o4=() -> {
            for(int i=0;i<1000;i++){
                c.increment();
            }
        };
        Thread t1=new Thread(o3);
        Thread t2=new Thread(o4);
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
                t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.count);

        
    }
}