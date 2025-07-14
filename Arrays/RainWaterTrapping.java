class Solution {
    public int trap(int[] height) {
        // TC: O(N)
        // SC:O(1)
        // int n=height.length;
        // int res=0,l=0,r=n-1;
        // //for corner cases
        // if(height.length==1 || height.length==2)
        // { return maxWater; } 
        // int lmax=height[l],rmax=height[r];
        // while(l<r)
        // {
        //     if(lmax < rmax)
        //     {
        //         l++;
        //         lmax=Math.max(lmax,height[l]);
        //         res+=lmax-height[l];
        //     }
        //     else{
        //         r--;
        //         rmax=Math.max(rmax,height[r]);
        //         res+=rmax-height[r];
        //     }
        // }
        // return res;

        // TC : O(N)
        // SC : O(2N)

        int maxWater=0,n=height.length;

        //for corner cases
        if(height.length==1 || height.length==2)
        { return maxWater; } 
        //calculate left max bound of array height
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++)
        {
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
         //calculate right max bound of array height
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        for(int i=0;i<n;i++)
        {
            // waterLevel min(left max bound ,right maxbound)
            int waterLevel=Math.min(leftMax[i],rightMax[i]);
            
            // Trapped water =waterLevel - height[i]
            maxWater+=waterLevel-height[i];
        }
        return maxWater;
    }
}