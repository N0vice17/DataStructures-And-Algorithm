package Stack;
public class StackUsingArray {
    private int arr[];
    private int topIndex;
    public StackUsingArray(){
        arr=new int[2];
        topIndex=-1;
    }
    public StackUsingArray(int size){
        arr=new int[size];
        topIndex=-1;
    }
    public int size(){
        return topIndex+1;
    }
    public void print(){
        for(int i=0;i<=topIndex;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public boolean isEmpty(){
        return topIndex==-1;
    }
    public void push(int element){
        if(topIndex==arr.length-1){
            doublecapacity();
        }
        topIndex=topIndex+1;
        arr[topIndex]=element;
    }
    private void doublecapacity(){
        int []temp=arr;
        arr=new int[2*temp.length];
        for(int i=0;i<temp.length;i++){
            arr[i]=temp[i];
        }
    }
    public void pop(){
        topIndex--;
    }
    public int top(){
        return arr[topIndex];
    }
}
