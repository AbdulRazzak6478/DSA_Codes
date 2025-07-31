package Recursion;

public class BasicRecursion {

    public static void increment(int n) {
        if (n == 0)
            return;
        increment(n - 1);
        System.out.print(n + " ");
    }

    public static void decrement(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        decrement(n - 1);
    }

    public static int factorial(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
            return 1;
        }
        System.out.print(n + " * ");
        int fact = factorial(n - 1);
        return n * fact;
    }

    public static int naturalNumber(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return 1;
        }
        int prevNum = naturalNumber(n - 1);
        System.out.print("+ " + n + " ");
        return n + prevNum;
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int prevFib = fibonacci(n - 1) + fibonacci(n - 2);
        return prevFib;
    }

    public static boolean isSorted(int[] arr, int i) {
        if (arr.length - 1 == i)
            return true;

        if (arr[i] <= arr[i + 1]) {
            return isSorted(arr, i + 1);
        } else {
            return false;
        }
    }

    public static int firstOccurrence(int[] arr, int i, int key) {
        if (arr.length == i)
            return -1;
        if (arr[i] == key) {
            return i;
        } else {
            return firstOccurrence(arr, i + 1, key);
        }
    }

    public static int lastOccurrence(int[] arr, int i, int key) {
        if (i < 0)
            return -1;
        if (arr[i] == key) {
            return i;
        } else {
            return lastOccurrence(arr, i - 1, key);
        }
    }

    public static void printArr(int[] arr, int i) {
        if (arr.length == i)
            return;
        System.out.print(arr[i] + " ");
        printArr(arr, i + 1);
    }

    public static int countOfBinaryStrings(int n) {
        // 1 -> {0,1}; => 2
        // 2 -> {0,0},{0,1},{1,0} => 3
        // 3 -> {0,0,0},{1,0,0},{0,1,0},{0,0,1},{1,0,1} => 5
        // 4 ->
        // {0,0,0,0},{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1},{1,0,1,0},{0,1,0,1},{1,0,0,1}
        // => 8
        if (n == 1)
            return 2;
        if (n == 2)
            return 3;
        return countOfBinaryStrings(n - 1) + countOfBinaryStrings(n - 2);
    }

    public static int findMaxElement(int[] arr, int i) {

        if (arr.length - 1 == i)
            return arr[i];
        int max = findMaxElement(arr, i + 1);
        return arr[i] >= max ? arr[i] : max;
    }

    public static int sumOfElements(int[] arr, int i) {
        if (arr.length - 1 == i)
            return arr[i];
        return arr[i] + sumOfElements(arr, i + 1);
    }

    // public static int power(int x, int n) {
    // if (n == 0)
    // return 1;
    // return x * power(x, n - 1);
    // }

    // public static int power_Optimised(int x, int n) {
    // if(n==0)return 1;
    // int half_square_root = power_Optimised(x, n / 2);
    // if (n % 2 == 0) {
    // return half_square_root * half_square_root;
    // } else {
    // return x * half_square_root * half_square_root;
    // }
    // }

    public static void main(String[] args) {
        System.out.println("Basic Recursion : ");

        System.out.println("Increasing Order");
        increment(10);
        System.out.println();
        System.out.println("Decrement Order");
        decrement(10);
        System.out.println();
        System.out.println();
        System.out.println("factorial :" + factorial(5));
        System.out.println();
        System.out.println("Natural Number : " + naturalNumber(10));
        System.out.println();
        System.out.println("Fibonacci Series : " + fibonacci(6));
        System.out.println();
        System.out.println("Is Array Sorted : " + isSorted(new int[] { 1, 2, 5, 4, 5, 6, 7, 8, 9, 6 }, 0));
        System.out.println();
        System.out.println("First Occurrence : " + firstOccurrence(new int[] { 1, 2, 3, 4, 5, 3, 4, 6, 5, 2 }, 0, 10));
        System.out.println();
        System.out.println("Last Occurrence : " + lastOccurrence(new int[] { 1, 2, 3, 4, 5, 3, 4, 6, 5, 2 }, 9, 4));
        System.out.println();
        System.out.println("Print Array: ");
        printArr(new int[] { 1, 2, 3, 4, 5, 3, 4, 6, 5, 2 }, 0);
        System.out.println();
        System.out.println(
                "Count Of The Total Binary Strings Which are not consecutive ones : " + countOfBinaryStrings(2));
        System.out.println();
        System.out.println("Max Element : " + findMaxElement(new int[] { 1, 2, 12, 4, 19, 3, 4, 6, 5, 2 }, 0));
        System.out.println();
        System.out.println("Sum Of Elements : " + sumOfElements(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 0));
    }

}
