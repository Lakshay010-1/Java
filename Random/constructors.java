package Random;

//constructors

class rectangle1{
    int length;
    int breadth;

    rectangle1(){
  length=4;
  breadth=5;
    }

    rectangle1(int l){
        length=l;
        breadth=5;
    }

rectangle1(int l,int b){
    this.length=l;
    this.breadth=b;

}
         public double area(){
        return length*breadth;
    }
}


class cuboid extends rectangle1{
    int height;

    cuboid(int l,int b,int h){
        super( l,b);
        this.height =h;
    }

    public double surfaceArea(){
        return 2*(length*breadth+breadth*height+height*length);
    }
}

public class constructors{
    public static void main(String[] args) {
        cuboid c1=new cuboid(3,2,5);
        System.out.println(c1.surfaceArea());

    }}
