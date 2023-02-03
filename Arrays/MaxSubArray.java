import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {

        // TC : O(N)
        // Kadane's Algorithm
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        boolean flag=false;
        for(int i=0;i<nums.length;i++)
        {
          if(nums[i]<0)
          {
              flag=true;
              continue;
          }
          else{
              flag=false;
              break;
          }
        }
        if(flag){
           for(int i=0;i<nums.length;i++)
           {
               maxSum=Math.max(maxSum,nums[i]);
           }
            // maxSum=Math.max(nums);
           return maxSum;
        }
        maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum<0)
            {
                sum=0;
            }
            maxSum=Math.max(sum,maxSum);
        }

        return maxSum;

        // Approach 2: prefix sum
        //     TC : O(N*2)
        // int prefix[]=new int[nums.length];
        // prefix[0]=nums[0];
        // for(int i=1;i<nums.length;i++)
        // {
        //     prefix[i]=prefix[i-1]+nums[i];
        // }
        // int maxsum=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++)
        // {
        //     for(int j=i;j<nums.length;j++)
        //     {
        //         int sum=0;
        //        sum=i==0 ? prefix[j]:prefix[j]-prefix[i-1];
        //         maxsum=Math.max(maxsum,sum);
        //     }
        // }
        // return maxsum;


        // Approach 1:
        //     TC : O(N*3)
        // int maxsum=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++)
        // {
        //     for(int j=i;j<nums.length;j++)
        //     {
        //         int sum=0;
        //         for(int k=i;k<=j;k++)
        //         {
        //             sum+=nums[k];
        //         }
        //         maxsum=Math.max(maxsum,sum);
        //     }
        // }
        // return maxsum;
    }
}