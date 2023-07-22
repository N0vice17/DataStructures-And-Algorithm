#include <iostream>
using namespace std;
class Node
{
public:
    int data;
    Node *next;
    Node(int data)
    {
        this -> data = data;
        this -> next = nullptr;
    }
};
class Stack
{
    Node *top = nullptr;
public:
    void push(int data)
    {
        Node *newNode = new Node(data);
        newNode -> next = top;
        top = newNode;
    }
    void pop()
    {
        if (!top)
        {
            cout << "Stack underflow !" << endl;
            exit(1);
        }
        Node *temp = top;
        top = top -> next;
        delete temp;
    }
    int peek()
    {
        if (!top)
        {
            cout << "Stack empty !" << endl;
            exit(2);
        }
        return top -> data;
    }
    bool isEmpty()
    {
        if (!top)
            return true;
        return false;
    }
};
int main()
{
    Stack s;
    s.push(3);
    s.push(2);
    s.push(1);
    s.pop();
    cout << s.peek();
    return 0;
}
