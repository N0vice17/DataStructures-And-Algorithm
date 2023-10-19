public class SearchRotatedArray {
    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findPivot(nums));
    }

    static int search(int[] nums, int target){
        int pivot = findPivot(nums);

        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }

        if(nums[pivot]==target){
            return pivot;
        }

        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot-1);
        }

        return binarySearch(nums, target, pivot+1, nums.length-1);

    }

    static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }

            if(mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }

            if(nums[mid]<=nums[start]){
                end = mid - 1;
            }
            else{
                start = mid+1;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target<arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid; 
            }
        }
        return -1;
    }
    
}
