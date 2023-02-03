class Solution {
    public int findPivot(int num[])
    {
        int s=0,e=num.length-1;
        while(s<e)
        {
            int mid=s+(e-s)/2;
            if(num[mid]>=num[e])
                s=mid+1;
            else
                e=mid;
        }
        return s;
    }
    public int BinarySearch(int arr[],int start,int end,int target)
    {
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int index=-1;
        //pivot is something where a new series start
        int pivot=findPivot(nums);
        if(nums[pivot]<=target && nums[nums.length-1]>=target)
            return BinarySearch(nums,pivot,nums.length-1,target);
        else
            return BinarySearch(nums,0,pivot-1,target);
    }
}