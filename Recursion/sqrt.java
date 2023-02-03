class Solution {
    public int mySqrt(int x) {
       if(x==0) return 0;
       int low = 1,high = x,ans =0;
       while(low<=high){
           int mid =low + (high-low)/2;
           if(x/mid==mid)  return mid;
           else if(x/mid<mid)   high=mid-1;
           else {low = mid+1; ans = mid;}
       }
       return ans;


       // if(x==0) return 0;
       // int i=1;
       // //using division instead of multiplication to avoid integer overflow
       // for(;i<=x/i;i++) 
       //     if(x/i==i)  return i;
       // return i-1; 
       // //returning (i-1) because at some point (i*i) became greater than x and loop stopped!!!
   
   }
}