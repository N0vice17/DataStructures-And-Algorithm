class Node: 
    def __init__(self,data): 
        self.data = data 
        self.next = None
          
 
def rotate(head,k): 
  
    last = head 
    temp = head 
      
  
    if head == None or k == 0: 
        return head 
          
   
    while last.next != None: 
        last = last.next
          
    
    while k: 
        
        head = head.next
          
        
        temp.next = None
          
       
        last.next = temp 
        last = temp 
          
         
        temp = head 
        k -= 1
    return head 
      
def printList(head): 
    temp = head 
    while temp: 
        print(temp.data, end = ' ') 
        temp = temp.next
    print() 
      
def push(head,new_data): 
    
    new_node = Node(new_data) 
      
    
    new_node.next = head 
      
  
    head = new_node 
    return head 
      
head = None

for i in range(60,0,-10): 
    head = push(head,i) 
      
print("Given linked list: ") 
printList(head) 
head = rotate(head,4) 
  
print("Rotated linked list: ") 
printList(head) 