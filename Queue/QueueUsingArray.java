package Queue;
public class QueueUsingArray {
    private int arr[];
    private int size;
    private int front;
    private int rear;
    public QueueUsingArray(){
        arr=new int[10];
        front=-1;
        rear=-1;
    }
    public QueueUsingArray(int capacity){
        arr=new int[capacity];
        front=-1;
        rear=-1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public int front(){
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    public void enqueue(int element){
        if(size==arr.length){
            rear=-1;
            int temp[]=arr;
            arr=new int[2*temp.length];
            int index=0;
            for(int i=front;i<temp.length;i++){
                arr[index]=temp[i];
                index++;
            }
            for(int i=0;i<front-1;i++){
                arr[index]=temp[i];
                index++;
            }
            front=0;
            rear=temp.length-1;
        }
        if(front==-1){
            front=front+1;
        }
        rear=rear+1;
        arr[rear]=element;
        size=size+1;
    }
    public int dequeue(){
        if(size==0){
            return -1;
        }
        int temp=arr[front];
        front=front+1;
        if(front==arr.length){
            front=0;
        }
        size=size-1;
        if(size==0){
            front=-1;
            rear=-1;
        }
        return temp;
    }
    public void print(){
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println( );
    }
}
