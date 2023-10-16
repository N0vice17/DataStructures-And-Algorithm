#include <stdio.h>
#define SIZE 30

void linear_search(int a[],int n);
void binary_search(int a[],int n);

void bubble_sort(int a[],int n);
void selection_sort(int a[],int n);
void insertion_sort(int a[],int n);
void merge(int a[],int lb,int mid,int ub);
void merge_sort(int a[],int lb,int ub);
int partition(int a[],int lb,int ub);
void quick_sort(int a[],int lb,int ub);
void display(int a[],int n);

int main()
{
    int choice,n,i,a[SIZE],lb=0,ub;
    
    printf("\n Enter number of elements: ");
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        printf("\n Enter Element %d: ",i+1);
        scanf("%d",&a[i]);
    }
    
    printf("\n Enter 1 for Linear search.");
    printf("\n Enter 2 for Binary search.");
    printf("\n Enter 3 for Bubble sort.");
    printf("\n Enter 4 for Selection sort.");
    printf("\n Enter 5 for Insertion sort.");
    printf("\n Enter 6 for Merge sort.");
    printf("\n Enter 7 for Quick sort.");
    printf("\n Enter 8 for display.");
    
    ub = n-1;
    while(1)
    {
        printf("\n Enter your choice: ");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1: linear_search(a,n);
                break;
            case 2: binary_search(a,n);
                break;
            case 3: bubble_sort(a,n);
                break;
            case 4: selection_sort(a,n);
                break;
            case 5: insertion_sort(a,n);
                break;
            case 6: merge_sort(a,lb,ub);
                break;
            case 7: quick_sort(a,lb,ub);
                break;
            case 8: display(a,n);
                break;
        }
    }
}

void linear_search(int a[],int n)
{
    int i,search,pos;
    printf("\n Enter element to be searched: ");
    scanf("%d",&search);
    
    for(i=0;i<n;i++)
    {
        if(a[i] == search)
        {
            printf("\n Element %d is found at position %d.",search,i+1);
            break;
        }
    }
}

void binary_search(int a[],int n)
{
    int beg=0,end=0,mid=0,search,pos=-1;
    printf("\n Enter element to be searched: ");
    scanf("%d",&search);
    
    end = n-1;
    while(beg <= end)
    {
        mid =(beg + end)/2;
        if(a[mid] == search)
        {
            pos = mid;
            printf("\n Element %d is found at position %d",search,pos+1);
            break;
        }
        else if(a[mid] > search)
        {
            end = mid - 1;
        }
        else
        {
            beg = mid + 1;
        }
    }
    if(pos == -1)
    {
        printf("\n Element not found");
    }
}

void bubble_sort(int a[],int n)
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

void selection_sort(int a[],n)
{
    int i,j,min,temp;
    for(i=0;i<n-1;i++)
    {
        min = i;
        for(j=i+1;j<n+1;j++)
        {
            if(a[min] > a[j])
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

void insertion_sort(int a[],int n)
{
    int i,j,temp;
    for(i=1;i<n;i++)
    {
        temp = a[i];
        for(j=i-1;j>=0 && temp<a[j];j--)
        {
            a[j+1] = a[j];
        }
        a[j+1] =temp;
    }
}

void merge(int a[],int lb,int mid,int ub)
{
    int i=lb,j=mid+1,temp[SIZE],index=lb,k;
    while((i<=mid) && (j<=ub))
    {
        if(a[i] < a[j])
        {
            temp[index] = a[i];
            i++;
        }
        else
        {
            temp[index] = a[j];
            j++;
        }
        index++;
    }
    if(i>mid)
    {
        while(j<=ub)
        {
            temp[index] = a[j];
            j++;
            index++;
        }
    }
    else
    {
        while(i<=mid)
        {
            temp[index] = a[i];
            index++;
            i++;
        }
    }
    
    for(k=lb;k<index;k++)
    {
        a[k] = temp[k];
    }
}

void merge_sort(int a[],int lb,int ub)
{
    int mid=0;
    if(lb<ub)
    {
        mid = (lb+ub)/2;
        merge_sort(a,lb,mid);
        merge_sort(a,mid+1,ub);
        
        merge(a,lb,mid,ub);
    }
}

int partition(int a[],int lb,int ub)
{
    int loc,left,right,temp,flag=0;
    right = ub;
    loc = left = lb;
    
    while(flag != 1)
    {
        while((a[loc]<=a[right]) && (loc!=right))
        {
            right--;
        }
        if(loc == right)
        {
            flag = 1;
        }
        else if(a[loc] > a[right])
        {
            temp = a[loc];
            a[loc] = a[right];
            a[right] = temp;
            loc = right;
        }
        if(flag != 1)
        {
            while((a[loc]>=a[left]) && (loc!=left))
            {
                left++;
            }
            if(loc == left)
            {
                flag = 1;
            }
            else if(a[loc] < a[left])
            {
                temp = a[loc];
                a[loc] = a[left];
                a[left] = temp;
                loc = left;
            }
        }
    }
    return loc;
}

void quick_sort(int a[],int lb,int ub)
{
    int loc;
    if(lb<ub)
    {
        loc = partition(a,lb,ub);
        quick_sort(a,lb,loc-1);
        quick_sort(a,loc+1,ub);
    }
}

void display(int a[],int n)
{
    int i;
    for(i=0;i<n;i++)
    {
        printf("\n Enter Element %d : %d",i+1,a[i]);
    }
}
