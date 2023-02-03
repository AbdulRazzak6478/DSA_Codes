package Recursion;

public class BasicRecursion {
    public static void increment(int n) {
        if (n == 0) {
            return;
        }
        increment(n - 1);
        System.out.print(n + " ");
    }

    public static void decrement(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        decrement(n - 1);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int naturalNo(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + naturalNo(n - 1);
        return sum;
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int sum = fibonacci(n - 1) + fibonacci(n - 2);
        return sum;
    }

    public static boolean isSorted(int arr[], int i) {
        if (arr.length - 1 == i) {
            return true;
        }
        if (arr[i] <= arr[i + 1]) {
            return isSorted(arr, i + 1);
        }
        return false;
    }

    public static int firstOccurence(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, i + 1, key);
    }

    public static int Last_Occurence(int arr[], int i, int key) {
        if (arr.length == i) {
            return -1;
        }
        int index = Last_Occurence(arr, i + 1, key);
        if (index == -1 && arr[i] == key) {
            return i;
        }
        return index;
    }

    public static int power(int x, int n) {
        if (n == 0)
            return 1;
        return x * power(x, n - 1);
    }

    public static int power_Optimised(int x, int n) {
        if(n==0)return 1;
        int half_square_root = power_Optimised(x, n / 2);
        if (n % 2 == 0) {
            return half_square_root * half_square_root;
        } else {
            return x * half_square_root * half_square_root;
        }
    }
    
   
}
