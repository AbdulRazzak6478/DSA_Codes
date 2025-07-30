package Recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeRecursion {

    public static void main(String[] args) {
        System.out.println("Basic Recursion");
    }

    // Q. 70
    public int climbStairs(int n) {
        // Q. 70
        // if (n == 1)
        // return 1;
        // if (n == 2)
        // return 2;
        // return climbStairs(n - 1) + climbStairs(n - 2);

        return climbStairsHash(n, new HashMap<>());
    }

    public int climbStairsHash(int n, Map<Integer, Integer> memo) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int stairs = climbStairsHash(n - 1, memo) + climbStairsHash(n - 2, memo);
        memo.put(n, stairs);
        return memo.get(n);
    }

    // Q.1137
    public int tribonacci(int n) {
        // Q. 1137
        // if (n == 0)
        // return 0;
        // if (n == 1 || n == 2)
        // return 1;
        // if(n == 3) return 2;
        // return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);

        return tribonacciHash(n, new HashMap<>());

    }

    public int tribonacciHash(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int num = tribonacciHash(n - 1, memo) + tribonacciHash(n - 2, memo) + tribonacciHash(n - 3, memo);
        memo.put(n, num);
        return memo.get(n);
    }

    public int nthtrib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // return nthtrib(n, dp);
        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    // Q. 509
    public int fib(int n) {
        // Q. 509

        // if (n == 0 || n == 1)
        // return n;
        // if (n == 2)
        // return 1;

        // return fib(n - 1) + fib(n - 2);
        return fibHash(n, new HashMap<>());
    }

    public int fibHash(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            return 1;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int num = fibHash(n - 1, memo) + fibHash(n - 2, memo);
        memo.put(n, num);
        return memo.get(n);
    }

}
