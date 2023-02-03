class Solution {
    public static int getIthBit(int n,int i)
    {
        int bitMask=1<<i;        
        if((n & bitMask)==0)
            return 0;
        else
            return 1;
        
    }
    public static int setIthBit(int n,int i)
    {
        int bitMask=1<<i;
        return (n | bitMask);
    }
    public static int clearIthBit(int n, int i)
    {
        int bitMask = (1<<i);
        // M2 : return n^bitMask;
        return (n & (~bitMask));
    }
    public static int updateIthBit(int n, int i, int newBit)
    {
        // if(newBit == 0)
        //     return (n & (~(1 << i)));
        // else
        //     return (n | (1 << i));
        

        // M2
        n = n | (newBit<<i);  // or clearIthBit(n ,i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }
    public static int clearLastIBits(int n, int i)
    {
        int bitMask = ((~0) << i);
        return (n & bitMask);
    }
    public static int clearRangeOfBits(int n, int i, int j)
    {
        int leftOfRange = ((~0) << (j+1));
        int rightOfRange =( (1 << i) - 1);
        return n & (leftOfRange | rightOfRange);
    }
    public static boolean isPowerOf2(int n)
    {
        int bitMask = (n-1);
        return ((n & bitMask )== 0);
    }
    public static int countSetBits(int n)
    {
        int count=0;
        while(n != 0)
        {
            if((n & 1) !=0 )
                count++;
            n=n>>1;
        }
        return count;
    }
    public static int Fast_Exponentiation(int a, int n)
    {       // ans = a^n
        // Ex : a=3 ,n=5;
//    (5^2^n)...(5^4)1  (5^2)0  (5^1)1
//                  \     |    /
//                        a
            // ans= (5^4)1 * (5^1)1
        int ans = 1;
        while(n != 0)
        {
            if((n & 1) !=0)
            {
                ans = ans *a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }
    public static void BitSwap(int x, int y)
    {
        System.out.println("Before Swap");
        System.out.println("X : "+x+" and Y : "+y);
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println("After swapping");
        System.out.println("X : "+x+" and Y : "+y);
    }
    // 1->0001
    // 2->0010
    // 3->0011
    // 4->0100
    // 5->0101
    // 6->0110
    // 7->0111
    // 8->1000
    // 9->1001
    // 10->1010
}