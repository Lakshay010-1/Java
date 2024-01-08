package Random;

class cylinder{
    private float radius,height;
    public cylinder(float radius,float height){
        this.radius=radius;
        this.height=height;
    }

    public void setRadius(float n){
        radius=n;
    }
    public void setHeight(float m){
        height=m;
    }
    public float getHeight(){
        return height;
    }
    public float getRadius(){
        return radius;
    }
    public float area(){
        return 2*3.14f*radius*(height+radius);    }

public float volume(){
        return 3.14f*radius*radius*height;     }



}
class rectangle{
    private int length,breadth;

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }

    public  rectangle(){
        length=4;
        breadth=5;
    }
    public rectangle(int length,int breadth){
        this.breadth=breadth;
        this.length=length;
    }
}

public class Area_rec_cyli{
    public static void main(String[] args) {
          cylinder c1=new cylinder(4,6);
           System.out.println(c1.volume());
           System.out.println(c1.area());

          rectangle r1=new rectangle();
          int k=r1.getBreadth();
          int m=r1.getLength();
            System.out.println(k);            
            System.out.println(m);

         rectangle r2=new rectangle(3,6);
            System.out.println(r2.getBreadth());
            System.out.println(r2.getLength());
    }

}
