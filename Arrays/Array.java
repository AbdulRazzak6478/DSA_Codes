import java.util.Scanner;

class Array {
    public static void reverseString() {
        char[] arr = { 'd', 'e', 'v', 'e', 'l', 'o', 'p', 'm', 'e', 'n', 't' };
        String word = new String(arr);
        System.out.println("Before Reverse : " + word);
        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            char ele = arr[first];
            arr[first] = arr[last];
            arr[last] = ele;
            first++;
            last--;
        }
        System.out.println("After Reverse: " + new String(arr));
    }

    public static int[] inputArray(int length) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        // sc.close();
        return arr;
    }

    public static void outputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void numberPattern() {
        // 1
        // 1 1
        // 1 2 1
        // 1 3 3 1
        // 1 4 6 4 1
        // 1 5 10 10 5 1
        // 1 6 15 20 15 6 1
        Scanner sc = new Scanner(System.in);
        // TC : O(N^2)
        // SC : 2N
        System.out.print("Enter Length of Pattern : ");
        int length = sc.nextInt();

        System.out.println("Pattern : ");
        int[] row = new int[length];
        int[] prev = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0 || i + 1 == length) {
                row[i] = 1;
                prev[i] = 1;
            } else {
                row[i] = 1;
                prev[i] = 1;
            }
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print(1 + " ");
                } else {
                    row[j] = prev[j] + prev[j - 1];
                    System.out.print(row[j] + " ");
                }
            }
            System.out.println();
            for (int k = 1; k < length; k++) {
                prev[k] = row[k];
            }
        }
        sc.close();
    }

    public static void starPattern() {
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
        // * * * * *
        // * * * *
        // * * *
        // * *
        // *
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length of Pattern : ");
        int length = sc.nextInt();
        for (int i = 1; i <= ((length % 2) == 0 ? length / 2 : (length / 2) + 1); i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = length / 2; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static void numberPattern2() {
        // 1
        // 2 1 2
        // 3 2 1 2 3
        // 4 3 2 1 2 3 4
        // 5 4 3 2 1 2 3 4 5
        // 4 3 2 1 2 3 4
        // 3 2 1 2 3
        // 2 1 2
        // 1
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length of Pattern : ");
        int length = sc.nextInt();

        for (int i = 1; i <= length; i++) {
            for (int j = i; j > 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = length - 1; i >= 1; i--) {
            for (int j = i; j > 1; j--) {
                System.out.print(j + " ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static void findMinValue() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length Of Array : ");
        int length = sc.nextInt();
        System.out.println("Enter Array Values :");
        int[] arr = inputArray(length);
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
            if (arr[i] > maxValue) {
                secondMax = maxValue;
                maxValue = arr[i];
            }
            if (arr[i] < maxValue && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        System.out.println("Output Array ");
        outputArray(arr);
        System.out.println();
        System.out.println("Max Value: " + maxValue);
        System.out.println("Min Value: " + minValue);
        System.out.println("Second Max Value: " + secondMax);
        sc.close();
    }

    public static void rotateArrayByNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length Of Array : ");
        int length = sc.nextInt();
        System.out.println("Enter Array Values :");
        int[] arr = inputArray(length);
        System.out.println("Number of elements to Rotate : ");
        int rotate = sc.nextInt();
        int rotateNumber = rotate % arr.length;
        while (rotateNumber > 0) {
            int temp = arr[arr.length - 1];
            for (int i = arr.length - 1; i >= 1; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
            rotateNumber--;
        }
        outputArray(arr);
        sc.close();
    }

    public static void getAllNonEmptySubArrays() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length Of Array : ");
        int length = sc.nextInt();
        System.out.println("Enter Array Values :");
        int[] arr = inputArray(length);
        int n = arr.length;

        int totalSubArrays = (n * (n + 1)) / 2;

        for (int i = 0; i < n; i++) {
            // System.out.println(arr[i]);
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + ", ");
                }
                System.out.println();
            }
        }

        System.out.println("Total Sub Arrays : " + totalSubArrays);
        // sc.close();
    }

    public static void getMaxSubArraySum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length Of Array : ");
        int length = sc.nextInt();
        System.out.println("Enter Array Values :");
        int[] arr = inputArray(length);
        int n = arr.length;

        int totalSubArrays = (n * (n + 1)) / 2;

        int maxSum = Integer.MIN_VALUE;

        // TC : O(N)
        // TC : O(N)
        // Kadane's Algorithm
        int sum = 0;
        maxSum = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                flag = true;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < arr.length; i++) {
                maxSum = Math.max(maxSum, arr[i]);
            }
            // maxSum=Math.max(nums);
            System.out.println("Maximum Sub Array Sum with Kadane's Algorithm : " + maxSum);
            return;
        }
        maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println("Maximum Sub Array Sum with Kadane's Algorithm : " + maxSum);

        // Approach 2: prefix sum
        // TC : O(N*2)
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0;
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                maxsum = Math.max(maxsum, sum);
            }
        }
        System.out.println("Maximum Sub Array Sum with Prefix sum: " + maxsum);
        maxSum = Integer.MIN_VALUE;

        // TC : N^3
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    // System.out.print(arr[k] + ", ");
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
                // maxSum = Math.max(sum,maxSum);
            }
        }
        System.out.println("Maximum Sub Array Sum With Brute force: " + maxSum);
        System.out.println("Total Sub Arrays: " + totalSubArrays);
    }

    public static void main(String[] args) {
        // System.out.println("DataTypes");
        // byte byteType = -127; // range upto -128 to 127, 1 byte
        // short shortType = 148; // 2 byte
        // char charType = 23; // 2 byte
        // boolean booleanType = false ; // 1byte
        // int intType = 234556686; // 4 byte, range : 536871066
        // long longType = 333454355; // 8 byte, range : 536871066
        // float floatType = 644334.5f; // 4 byte
        // double doubleType = 54546666.634534534345345345345;
        // System.out.println("Value:
        // "+byteType+shortType+charType+booleanType+intType+longType+floatType+doubleType);

        Scanner sc = new Scanner(System.in);
        boolean isCompleted = false;
        // Rotate Array
        while (isCompleted != true) {
            System.out.println();
            // Rotate Elements
            // rotateArrayByNumber();
            // getAllNonEmptySubArrays();
            getMaxSubArraySum();
            System.out.println("Enter 1 to Continue or 0 to Exist : ");
            int value = sc.nextInt();
            if (value == 0) {
                isCompleted = true;
            }
        }
        sc.close();
    }
}