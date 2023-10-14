#include<stdio.h>
void print(int arr[],int n) 
{
	int i;
	for(i=0;i<n;i++)
	{
		printf("%d ",arr[i]);
	}
}
int Search(int arr[],int n,int ele_search)
{
	int low=0,high=n-1;
	int pos;
	while(low<=high)
	{
	  pos=low+(double)(((high-low)*(ele_search-arr[low])	)/(arr[high]-arr[low])); //Formula for getting the position to be searched
	  if(arr[pos]>ele_search)
	  {
	  	high=pos-1;
	  }
	  else if(arr[pos]<ele_search)
	  {
	  	low=pos+1;
	  }
	  else if(arr[pos]==ele_search)
	  {
	  	return (pos);//if found
	  }
	}
	return -1;//if not found
}
int main()
{
	int n;
	printf("Enter the size of the array:");
	scanf("%d",&n);
	int arr[n];
	int i;
	printf("Enter the elements in the array:\n");
	for(i=0;i<n;i++)
	{
		scanf("%d",&arr[i]);
	}
	print(arr,n);
	int ele_search;
	printf("\nEnter the element to be searched:");
	scanf("%d",&ele_search);
	int find=Search(arr,n,ele_search);
	if(find!=-1)
	{
		printf("Found at %d",find);
	}
	else
	{
		printf("not found");
	}
	
	
}
