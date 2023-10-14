#include <stdio.h>
#define SIZE 30

void linear_search(int n,int a[]);
void binary_search(int n,int a[]);
void bubble_sort(int n,int a[]);
void selection_sort(int n,int a[]);
void insertion_sort(int n,int a[]);
void display(int n,int a[]);

int main()
{
    int a[SIZE],choice=1,n,i;
    printf("\n Enter 1 to perform Linear Search.");
    printf("\n Enter 2 to perform Binary Search.");
    printf("\n Enter 3 to perform Bubble Sort.");
    printf("\n Enter 4 to perform Selection Sort.");
    printf("\n Enter 5 to perform Insertion Sort.");
    printf("\n Enter 6 to perform Merge Sort.");
    printf("\n Enter 7 to perform Qucik Sort.");
    printf("\n Enter 8 for Display.");
    
    printf("\n Enter number of elements to be inserted: ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("Enter Element %d: ",i);
        scanf("%d",&a[i]);
    }

    while(choice != 0)
    {
        printf("\n Enter choice: ");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1:linear_search(n,a);
                break;
            case 2:binary_search(n,a);
                break;
            case 3:bubble_sort(n,a);
                break;
            case 4:selection_sort(n,a);
                break;
            case 5:insertion_sort(n,a);
                break;
            case 6:display(n,a);
                break;
        }
    }
}

void linear_search(int n,int a[])
{
    int search,i;
    printf("\n Enter the element to be searched: ");
    scanf("%d",&search);
    for(i=0;i<n;i++)
    {
        if(a[i]==search)
        {
            printf("\n The element %d is at position %d.",search,i+1);
            break;
        }
    }
}

void binary_search(int n,int a[])
{
    int beg=0,mid=0,end=0,pos=-1,search;
    printf("\n Enter the element to be searched: ");
    scanf("%d",&search);
    
    end = n-1;
    mid = (beg+end)/2;
    
    while(beg<=end)
    {
        if(a[mid] == search)
        {
            pos = mid;
            printf("\n The element %d is at position %d.",search,pos+1);
            break;
        }
        else if(a[mid] > search)
        {
            end = mid - 1;
            mid = (beg + end)/2;
        }
        else
        {
            beg = mid + 1;
            mid = (beg + end)/2;
        }
    }
    if(pos == -1)
    {
        printf("\n Enter noy found.");
    }
}

void bubble_sort(int n,int a[])
{
    int i,j,temp;
    for(i=0;i<n;i++)
    {
        for(j=0;j<n-i-1;j++)
        {
            if(a[j] > a[j+1])
            {
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
    }
}

void selection_sort(int n,int a[])
{
    int i,j,min,temp;
    for(i=0;i<n-1;i++)
    {
        min = i;
        for(j=i+1;j<n;j++)
        {
            if(a[j]<a[min])
            {
                min = j;
            }
        }
        if(min != i)
        {
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}

void insertion_sort(int n,int a[])
{
    int i,j,temp;
    for(i=1;i<n;i++)
    {
        temp = a[i];
        for(j=i-1;j>=0 && temp<a[j];j--)
        {
            a[j+1] = a[j];
        }
        a[j+1] = temp;
    }
}

void display(int n,int a[])
{
    int i;
    printf("\n Elements are: ");
    for(i=0;i<n;i++)
    {
        printf("%d\t",a[i]);
    }
}
