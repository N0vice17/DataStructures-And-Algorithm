#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
    struct node *prev;
}*head,*head1,*newnode,*temp,*ptr;

void create_node();
void insert_beginning();
void insert_end();
int count_node();
void insert_after_node();
void insert_before_node();
void delete_beginning();
void delete_end();
void delete_after();
void delete_before();
void sort_node();
void splitting();
void merging();
void count_odd_even();
void display(*head);


int main()
{
    int choice;
    printf("Enter 1 to create a node.");
    printf("\nEnter 2 to insert node at the beginning.");
    printf("\nEnter 3 to insert node at the end.");
    printf("\nEnter 4 to insert a node after a given node.");
    printf("\nEnter 5 to insert a node before a given node.");
    printf("\nEnter 6 to delete node at the beginning.");
    printf("\nEnter 7 to delete node at the end.");
    printf("\nEnter 8 to delete after a given node.");
    printf("\nEnter 9 to delete before a given node.");
    printf("\nEnter 10 to sort the nodes.");
    printf("\nEnter 11 to split node.");
    printf("\nEnter 12 to merge nodes.");
    printf("\nEnter 13 to count odd and even nodes.");
    printf("\nEnter 14 to display node.");
    printf("\n==========================================================");
    while(choice != 0 )
    {
        printf("\nSelect your choice:");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1:create_node();
            break;
            case 2:insert_beginning();
            break;
            case 3:insert_end();
            break;
            case 4:insert_after_node();
            break;
            case 5:insert_before_node();
            break;
            case 6:delete_beginning();
            break;
            case 7:delete_end();
            break;
            case 8:delete_after();
            break;
            case 9:delete_before();
            break;
            case 10:sort_node();
            break;
            case 11:splitting();
            break;
            case 12:merging();
            break;
            case 13:count_odd_even();
            break;
            case 14:display(head);
            break;
            default:printf("choice doesn't exist");
        }
    }
}

void create_node()
{
    int value;
    newnode=(struct node*)malloc(sizeof(struct node));
    printf("Enter data for the node:");
    scanf("%d",&value);
    newnode->data=value;
    
    newnode->next=NULL;
    newnode->prev = NULL;
    
    if(head==NULL)
    {
        head=newnode;
        temp = newnode;
    }
    else
    {
        temp ->next = newnode;
        temp = newnode;
    }
}

int count_node()
{
    int count=0;
    temp=head;
    while(temp != NULL)
    {
        count++;
        temp=temp->next;
    }

    return count;
}

void insert_beginning()
{
    int a;
    newnode=(struct node*)malloc(sizeof(struct node));
    printf("\nEnter data to insert at beginning:");
    scanf("%d",&a);
    newnode->data=a;
    
    newnode->next=NULL;
    newnode->prev = NULL;

    newnode->next=head;
    head->prev = newnode;
    head=newnode;
}

void insert_end()
{
    int a;
    newnode=(struct node*)malloc(sizeof(struct node));
    printf("\nEnter data to insert at end:");
    scanf("%d",&a);
    newnode->data=a;
    
    newnode->next=NULL;
    newnode->prev = NULL;
   
    temp = head;
    while(temp ->next != NULL)
    {
        temp = temp->next;
    }
    temp ->next = newnode;
    newnode ->prev = temp;
}

void insert_after_node()
{
    int a,count=0,pos,i=0;
    newnode=(struct node*)malloc(sizeof(struct node));
    printf("Enter the position after which new data is to be inserted:");
    scanf("%d",&pos);
    printf("\nEnter data to insert after a given position:");
    scanf("%d",&a);
    newnode->data = a;
    
    count=count_node();
    
    newnode->next=NULL;
    newnode->prev = NULL;
    
    temp=head;
    if(pos>count || pos==0)
    {
        printf("INVALID POSITION");
    }
    else
    {
        temp = head;
        newnode->next=NULL;
        newnode->prev = NULL;
        if(pos == count)
        {
            while(temp ->next != NULL)
            {
                temp = temp->next;
            }
            temp ->next = newnode;
            newnode ->prev = temp;
        }
        else
        {
            for(i=1;i<pos;i++)
            {
                temp = temp->next;
            }
            newnode->next = temp->next;
            temp->next->prev = newnode;
            newnode->prev = temp;
            temp->next = newnode;
        }
    }
}

void insert_before_node()
{
    int a,count=0,pos,i=1;
    newnode=(struct node*)malloc(sizeof(struct node));
    printf("Enter the position before which new data is to be inserted:");
    scanf("%d",&pos);
    printf("\nEnter data to insert before a given position:");
    scanf("%d",&a);
    newnode->data = a;

    count=count_node();

    if(pos>count || pos==0)
    {
        printf("INVALID POSITION");
    }
    else
    {
        temp=head;
        newnode->next=NULL;
        newnode->prev = NULL;
        if(pos == 1)
        {
            newnode->next=head;
            head->prev = newnode;
            head=newnode;
        }
        else
        {
            for(i=1;i<pos-1;i++)
            {
                temp = temp->next;
            }
            newnode->next = temp->next;
            temp->next->prev = newnode;
            newnode->prev = temp;
            temp->next = newnode;
        }
    }
}

void delete_beginning()
{
    if(head==NULL)
    {
        printf("The list the empty");
    }
    else
    {
        temp=head;
        head=head->next;
        head->prev=NULL;
        free(temp);
    }
}

void delete_end()
{
    if(head==NULL)
    {
        printf("The list is empty");
    }
    else
    {
        temp=head;
        while(temp->next != NULL)
        {
            ptr = temp;
            temp=temp->next;
        }
        ptr ->next = NULL;
        free(temp);
    }
}

void delete_after()
{
    int pos,i=1;
    printf("\nEnter position after which the node is to be deleted:");
    scanf("%d",&pos);
    int count=count_node();
    
    if(head==NULL)
    {
        printf("the list is empty");
    }
    else
    {
        if(pos>count || pos==0)
        {
            printf("INVALID POSITION");
        }
        else
        {
            temp=head;
            if(pos == (count-1))
            {
                while(temp->next != NULL)
                {
                    ptr = temp;
                    temp=temp->next;
                }
                ptr ->next = NULL;
                free(temp);
            }
            else
            {
                for(i=1;i<pos;i++)
                {
                    temp = temp->next;
                }
                ptr = temp ->next;
                temp->next = ptr->next;
                ptr->next->prev = temp;
                free(ptr);
            }
        }
    }
}

void delete_before()
{
    int pos,i=1;
    printf("\nEnter position before which the node is to be deleted:");
    scanf("%d",&pos);
    int count=count_node();
    
    if(head==NULL)
    {
        printf("The list is empty");
    }
    else
    {
        temp=head;
        if(pos>count || pos==0)
        {
            printf("INVALID POSITION");
        }
        else if(pos == 1)
        {
            printf("\nNo node exist.");
        }
        else if(pos == 2)
        {
            temp=head;
            head=head->next;
            head->prev=NULL;
            free(temp);
        }
        else
        {
            for(i=1;i<pos-1;i++)
            {
                ptr = temp;
                temp = temp->next;
            }
            ptr->next = temp->next;
            temp->next->prev = ptr;
            free(temp);
        }
    }
}

void sort_node()
{
    int a;
    temp=head;
    while(temp->next != NULL)
    {
        ptr=temp->next;
        while(ptr != NULL)
        {
            if(temp->data > ptr->data)
            {
                a=temp->data;
                temp->data=ptr->data;
                ptr->data=a;
            }
            ptr=ptr->next;
        }
        temp=temp->next;
    }
}

void splitting()
{
    int c,pos,i;
    c = count_node();
    printf("\ncount = %d",c);
    if(head == NULL)
    {
        printf("\nNo list exist.");
    }
    else
    {
        temp = head;
        pos = c/2;
        for(i=1;i<pos;i++)
        {
            temp = temp->next;
        }
        head1 = temp->next;
        temp->next = NULL;
    }
    display(head);
    display(head1);
}

void merging()
{
    splitting();
    temp = head;
    while(temp->next != NULL)
    {
        temp = temp->next;
    }
    temp->next = head1;
    display(head);
}

void count_odd_even()
{
    int odd=0,even=0,c;
    c = count_node();
    
    if(head == NULL)
    {
        printf("\nNo list.");
    }
    else if(head->next == NULL)
    {
        printf("\n1 odd node.");
    }
    else
    {
        even = c/2;
        odd = c-even;
        printf("\n Odd node = %d",odd);
        printf("\n Even node = %d",even);
        
    }
}

void display(*head)
{
    temp=head;
    printf("\nhead->");
    while(temp != NULL)
    {
        printf("%d->",temp->data);
        temp=temp->next;
    }
    printf("\n");
}
