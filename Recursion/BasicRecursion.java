package Recursion;

import java.util.Arrays;

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

    public static int sumOfStringDigits(String numStr) {

        // '4' - '0' => 4
        if (numStr.length() == 1)
            return numStr.charAt(0) - '0';

        return (numStr.charAt(0) - '0') + sumOfStringDigits(numStr.substring(1));
    }

    public static int stringToNumber(String numStr) {
        if (numStr.length() == 1)
            return numStr.charAt(0) - '0';

        // int length = numStr.length() - 1;
        // int digit = numStr.charAt(0) - '0';
        // while(length != 0)
        // {
        // digit*= 10;
        // length--;
        // }
        // return stringToNumber(numStr.substring(1)) + digit;

        // For Reverse Num
        int digit = numStr.charAt(0) - '0';
        int num = stringToNumber(numStr.substring(1)) * 10;
        return num + digit;
    }

    public static boolean isPalindrome(String str) {
        if (str.length() == 1)
            return true;
        if (str.length() == 2 && str.charAt(0) == str.charAt(1)) {
            return true;
        }

        return str.charAt(0) != str.charAt(str.length() - 1) ? false : isPalindrome(str.substring(1, str.length() - 1));
    }

    public static String addConsecutiveString(String str, int i) {
        if (str.length() - 1 == i)
            return str;

        if (str.charAt(i) == str.charAt(i + 1)) {
            str = str.substring(0, i + 1) + "*" + str.substring(i + 1);
            i = i + 1;
        }
        return addConsecutiveString(str, i + 1);
    }

    public static String moveXToEndString(String str, int i, int s, int e, StringBuilder newStr) {
        if (str.length() == i) {
            return newStr.toString();
        }
        if (str.charAt(i) == 'x') {
            newStr.setCharAt(e, 'x');
            e--;
        } else {
            newStr.setCharAt(s, str.charAt(i));
            s++;
        }

        return moveXToEndString(str, i + 1, s, e, newStr);
    }

    public static String bracketString(String str, int i, int s) {
        if (str.charAt(i) == ')' || str.length() - 1 == i) {
            if (s + 1 == i)
                return "";
            return str.substring(s + 1, i );
        }
        if (str.charAt(i) == '(') {
            s = i;
        }
        return bracketString(str, i + 1, s);
    }

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

        System.out.println();
        System.out.println("Sum Of Digits Of String : " + sumOfStringDigits("12345") + " " + ('4' - '0'));
        System.out.println();
        System.out.println("Convert The Number String into Number :" + stringToNumber("12345") + " (Type: "
                + ((Object) stringToNumber("12345")).getClass().getSimpleName() + ")");

        System.out.println();
        System.out.println("Is String is palindrome : " + isPalindrome("racecar"));

        System.out.println();
        System.out.println("Add * Into duplicate Consecutive characters : "
                + addConsecutiveString("I  m aa softtwaree engiineer", 0));

        System.out.println();
        String str = "axbcdxxexfgxhxixxjklmxxnoxpqxxrxsxtxuxvxwxyxz";
        System.out.println(
                "Move x To End Of String : " + moveXToEndString(str, 0, 0, str.length() - 1, new StringBuilder(str)));

        System.out.println();
        System.out.println("Get The Bracket String : " + bracketString("(fgghgh)", 0, 0));
    }

}
