package Queue;

//Queue using a arrays.(Two types)
public class queue_01 {

    //Queue using a array
    static class QueueArr{
        static int arr[];
        static int size;
        static int rear;

        QueueArr(int sizeArr){
            arr=new int[sizeArr];
            size=sizeArr;
            rear=-1;
        }
        //isEmpty operation TC--~0(1)
        public static boolean isEmpty(){
            return rear==-1;
        }
        //add operation TC--~0(1)
        public static void add(int data){
            if(rear==size-1){
                System.out.println("Queue is full.");
                return;
            }
            rear++;
            arr[rear]=data;
        }
        //remove operation TC--~0(n)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            int front=arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;            
        }
        //peek operation TC--~0(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return arr[0];
        }
        //print array TC--~0(n)
        public static void printQuAr(){
            if(rear==-1){
                System.out.println("Queue is Empty");
                return;
            }
            for(int i=0;i<=rear;i++){
                System.out.print(arr[i]+" ");                
            }
            System.out.println();
        }
    }

    //Queue using a circular array
    static class QueueCirArr{
        static int arr[];
        static int size;
        static int front;
        static int rear;

        QueueCirArr(int sizeArr){
            arr=new int[sizeArr];
            size=sizeArr;
            front=-1;
            rear=-1;
        }
        
        //isEmpty operation TC--~0(1)
        public static boolean isEmpty(){
            return front==-1 && rear==-1;
        }

        //isFull operation TC--~0(1)
        public static boolean isFull(){
            return front==(rear+1)%size;
        }

        //add operation TC--~0(1)
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return ;
            }
            if(isEmpty()){
                front++;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }

        //remove operation TC--~0(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is epmty");
                return Integer.MIN_VALUE;
            }
            int top=arr[front];
            if(rear==front){
                rear=front=-1;
            }
            else{
                front=(front+1)%size;
            }
            return top;
        }

        //peek operation TC--~0(1)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return Integer.MIN_VALUE;
            }
            return arr[front];
        }

        //print Queue Circular array; TC--~0(n)
        public static void printQuCiAr(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return;
            }
            for(int i=front;i<size;i++){
                System.out.print(arr[i]+" ");
            }
            if(rear==size-1){
                System.out.println();
                return;
            }
            for(int j=0;j<=rear;j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        /* 
        //circular array
        QueueCirArr qac=new QueueCirArr(3);
        qac.add(1);
        qac.add(2);
        qac.add(3);
        qac.printQuCiAr();
       System.out.println("remove="+qac.remove());
        qac.printQuCiAr();
        qac.add(4);
        System.out.println("peek="+qac.peek());
        qac.printQuCiAr();
        */

        /* 
        //array
        QueueArr qa=new QueueArr(3);
        qa.add(1);
        qa.add(2);
        qa.add(3);
        qa.printQuAr();
        qa.remove();
        qa.printQuAr();
        qa.add(4);
        System.out.println("peek="+qa.peek());
        qa.printQuAr();
        */        
        
        /* 
        //to print an queue
         while(!ql.isEmpty()){
            System.out.println(ql.remove());
         }
        */
    }    
}
