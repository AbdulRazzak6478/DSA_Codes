import java.util.* ;
import java.io.*; 
public class Solution {
    public static int numberOfWays(int n) {
        // Write your code here.
        if(n==1 ||n==2)
            return n;
        return (numberOfWays(n-1))+((n-1)*numberOfWays(n-2));
    }
}

