class Solution {
    public int firstPosition(int nums[],int key){
        int n=nums.length;
        int s=0,e=n-1;
        int ans=-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(nums[mid]==key)
            {
                ans=mid;
                e=mid-1;
            }
            else if(nums[mid]<key)
                s=mid+1;
            else
                e=mid-1;
        }
        return ans;
    }
    public int lastPosition(int nums[],int key){
        int n=nums.length,s=0,e=n-1;
        int ans=-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(nums[mid]==key)
            {
                ans=mid;
                s=mid+1;
            }
            else if(nums[mid]<key)
                s=mid+1;
            else
                e=mid-1;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[]=new int[2];
        ans[0]=firstPosition(nums,target);
        ans[1]=lastPosition(nums,target);
        return ans;
    }
}