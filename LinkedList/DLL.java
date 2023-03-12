package LinkedList;
public class DLL<T> {
    public DLL<Integer> next;
    public DLL<Integer> back;
    public int data;
    public DLL(int data){
        this.data=data;
    }
    public DLL(DLL<Integer>next,DLL<Integer>back,int data){
        this.next=next;
        this.back=back;
        this.data=data;
    }
    
}
