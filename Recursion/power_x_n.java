
class Solution {
    public double power(double x,int n)
    {
        if(n==0)
        {
            return 1.0;
        }
        double ans=power(x,n/2);
        if(n%2==0)
        {
            return ans*ans;
        }
        else 
            return x*ans*ans;
        // return x * power(x,n-1);
    }
    public double myPow(double x, int n) {
       if(n<0)
       {
           return (1/power(x,-n));
       }
       return power(x,n);
    }
}
