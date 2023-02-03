class Solution {
    public int findGCD(int[] nums) {
        int small =Integer.MAX_VALUE;
        int large =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<small)
                small=nums[i];
            if(nums[i]>large)
                large=nums[i];
            
        }
        int i=1;
        int gcd=1;
        for(;i<=small;i++)
        {
            if(small%i==0 && large%i==0)
            {
                gcd=i;
            }
        }
        return gcd;
    }
}
