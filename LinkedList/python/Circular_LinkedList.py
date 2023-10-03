class Node:    #for node creation
    def __init__(self,data):  
        self.data=data
        self.next=None
        
        
class link:
    def __init__(self):
        self.head=None
    def insertBeg(self,newnode):  #Inserting from beginning
        if(self.head==None):
            newnode.next=newnode  #Connecting the next to itself
            self.head=newnode    #assigning the head as the newnode
        else:
            ptr=self.head
            while(ptr.next!=self.head):#It will run until it gets the next the head node
                ptr=ptr.next

            ptr.next=newnode
            newnode.next=self.head
            self.head=newnode
            
    def insertEnd(self,newnode):#inserting from end
        if(self.head==None):
            self.head=newnode
        else:
            
            ptr=self.head
            while(ptr.next!=self.head):
                ptr=ptr.next
            ptr.next=newnode
            
            newnode.next=self.head
            
    def insertAny(self,newnode,val):#inserting at any position
        if(self.head==None):
            self.head=newnode
        else:
            
            ptr=self.head
            while(ptr.next!= self.head and ptr.data!=val):
                ptr=ptr.next
            newnode.next=ptr.next
            
            
            ptr.next=newnode
            
            
    def deleteBeg(self):#delete from beginning
        strt=self.head
        ptr=self.head
        while(ptr.next!= self.head):
                ptr=ptr.next
        ptr.next=strt.next
        
        self.head=strt.next
        del strt
    def deleteEnd(self):#delete from end
        strt=self.head
        
        while(strt.next.next!=self.head):
            strt=strt.next
        ptr=strt.next
        strt.next=self.head
        
        del ptr
    def deleteAny(self,ele):#delete from any position
        strt=self.head
        
        while(strt.next!=self.head and strt.next.data!=ele):
            strt=strt.next
        ptr=strt.next
        strt.next=ptr.next
        
        del ptr
    def print(self):#printing
        nodes=self.head
        while(nodes.next!=self.head):
            print(nodes.data)
            nodes=nodes.next
        print(nodes.data)
n=int(input("Enter the number of nodes:"))
l=link()
for i in range (n):
    ele=int(input("enter the element in the list:"))
    enter=Node(ele)
    choice=int(input("enter 1 to enter at the beginning and 2 to add the end and 3 to enter at any position:"))
    match (choice):
           case 1:
             l.insertBeg(enter)
           case 2:
             l.insertEnd(enter)
           case 3:
             bef=int(input("Enter the element after which to be added:"))
             l.insertAny(enter,bef)
           case _:
             print("enter properly")
l.print()
d=int(input("Enter 1 to perform deletion and -1 to stop:"))
while(d!=-1):
    
    choice=int(input("enter 1 to delete at the beginning and 2 to delete the end and 3 to delete from any position:"))
    match (choice):
           case 1:
             l.deleteBeg()
           case 2:
             l.deleteEnd()
           case 3:
             bef=int(input("Enter the element to be deleted:"))
             l.deleteAny(bef)
           case _:
             print("enter properly")
    d=int(input("Enter 1 to perform deletion and -1 to stop:"))
print("\n")
l.print()

        

        
        