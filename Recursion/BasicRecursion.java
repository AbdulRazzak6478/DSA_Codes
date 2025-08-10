package Recursion;

import java.util.ArrayList;
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
            return str.substring(s + 1, i);
        }
        if (str.charAt(i) == '(') {
            s = i;
        }
        return bracketString(str, i + 1, s);
    }

    // pattern Questions
    public static void printSquareStarPattern(int n, int idx) {
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        if (idx >= n)
            return;
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
        printSquareStarPattern(n, idx + 1);
    }

    public static void printSquareStarPatternWithOneRecursive(int n, int r, int c) {
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *

        if (r > n)
            return;

        if (c > n) {
            r++;
            c = 1;
            System.out.println();
        } else {
            System.out.print("* ");
            c++;
        }
        printSquareStarPatternWithOneRecursive(n, r, c);
    }

    public static void printHalfTriangleStarPattern(int n, int r, int c) {
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *

        if (r > n)
            return;

        if (c > r) {
            r++;
            c = 1;
            System.out.println();
        } else {
            System.out.print("* ");
            c++;
        }
        printHalfTriangleStarPattern(n, r, c);
    }

    public static void printHalfDownwardTriangleStarPattern(int n, int r, int c) {
        // * * * * *
        // * * * *
        // * * *
        // * *
        // *

        if (r >= n)
            return;

        if (c >= n - r) {
            r++;
            c = 0;
            System.out.println();
        } else {
            System.out.print("* ");
            c++;
        }
        printHalfDownwardTriangleStarPattern(n, r, c);
    }

    public static void halfTriangleNumberPattern(int n, int r, int c, int[][] result) {
        // 1
        // 1 1
        // 1 2 1
        // 1 3 3 1
        // 1 4 6 4 1
        // 1 5 10 10 5 1
        // 1 6 15 20 15 6 1
        // 1 7 21 35 35 21 7 1
        if (r >= n)
            return;

        if (c == 0 || c == r) {
            result[r][c] = 1;
            System.out.print(1 + " ");
            if (c == r) {
                System.out.println();
                c = 0;
                r++;
            } else {
                c++;
            }
        } else {
            int element = result[r - 1][c] + result[r - 1][c - 1];
            result[r][c] = element;
            System.out.print(element + " ");
            c++;
        }
        halfTriangleNumberPattern(n, r, c, result);
    }

    public static int lastIndexOfKey(int[] arr, int i, int key) {
        if (i < 0)
            return -1;
        if (arr[i] == key) {
            return i;
        } else {
            return lastIndexOfKey(arr, i - 1, key);
        }
    }

    public static ArrayList<Integer> indicesOfKey(int[] arr, int i, int key, ArrayList<Integer> ans) {
        if (i == arr.length)
            return ans;
        if (arr[i] == key) {
            ans.add(i);
        }
        return indicesOfKey(arr, i + 1, key, ans);
    }

    public static Boolean isPalindrome(int[] arr, int i) {

        if (i >= arr.length / 2)
            return true;

        if (arr[i] != arr[arr.length - i - 1]) {
            return false;
        }

        return isPalindrome(arr, i + 1);
    }

    public static int[] reverseArr(int[] arr, int i) {
        if (i >= arr.length / 2)
            return arr;

        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;

        return reverseArr(arr, i + 1);
    }

    public static ArrayList<String> StringSubsequence(String str, int i, ArrayList<String> ans) {

        if (i == str.length()) {
            ans.add("");
            return ans;
        }

        ArrayList<String> temp = new ArrayList<>(StringSubsequence(str, i + 1, ans));
        for (int j = 0; j < temp.size(); j++) {
            String st = str.charAt(i) + temp.get(j);
            ans.add(st);
        }
        return ans;
    }

    public static void StringSubsequence2(String str, int i, String ans) {
        if (str.length() == i) {
            System.out.println("[" + ans + "]");
            return;
        }
        StringSubsequence2(str, i + 1, ans + str.charAt(i));
        StringSubsequence2(str, i + 1, ans);
    }

    public static String[] result = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void keyboardLetterCombinations(String num, int i, String ans) {

        if (num.length() == i) {
            System.out.println("[" + ans + "]");
            return;
        }
        int digit = num.charAt(i) - '0';
        for (int k = 0; k < result[digit].length(); k++) {
            keyboardLetterCombinations(num, i + 1, ans + result[digit].charAt(k));
        }
    }

    public static void lexicalOrder(int n, int i) {
        if (i <= n) {
            if (i != 0) {
                System.out.print(i + " ");
            }
        } else {
            return;
        }

        for (int k = 0; k <= 9; k++) {
            if (i == 0 && k == 0)
                continue;
            lexicalOrder(n, i * 10 + k);
        }
    }

    public static int possibleWaysToTarget(int n, int m, int r, int c, String ans) {
        if (r == n - 1 && c == m - 1) {
            System.out.println(ans);
            return 1;
        }

        if (r >= n || c >= m)
            return 0;

        return possibleWaysToTarget(n, m, r, c + 1, ans + "R") + possibleWaysToTarget(n, m, r + 1, c, ans + "D");
    }

    public static int asciiSubsequence(String str, int i, String ans) {
        if (i == str.length()) {
            System.out.println("[" + ans + "]");
            return 1;
        }

        int asci = str.charAt(i) - 'a' + 97;
        return asciiSubsequence(str, i + 1, ans + str.charAt(i)) + asciiSubsequence(str, i + 1, ans + asci)
                + asciiSubsequence(str, i + 1, ans);
    }

    public static int subsetSumToTarget(int[] arr, int i, int target, ArrayList<Integer> ans) {
        if (i == arr.length) {
            int sum = 0;
            for (int j = 0; j < ans.size(); j++) {
                sum += ans.get(j);
            }
            if (sum == target) {
                System.out.println(ans);
                return 1;
            }
            // System.out.println(ans);
            return 0;
        }
        ans.add(arr[i]);
        int sum = subsetSumToTarget(arr, i + 1, target, ans);
        ans.remove(ans.size() - 1);
        sum +=subsetSumToTarget(arr, i + 1, target, ans);
        return sum;
    }

    public static int personPossibleWays(int n)
    {
        if(n == 1 || n == 2) return n; 

        return personPossibleWays(n-1) + (n-1) * personPossibleWays(n-2);
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

        System.out.println();
        System.out.println("Print Rectangle Star Pattern ");
        printSquareStarPattern(5, 0);
        System.out.println();
        printSquareStarPatternWithOneRecursive(5, 1, 1);
        System.out.println();
        printHalfTriangleStarPattern(5, 1, 1);
        System.out.println();
        printHalfDownwardTriangleStarPattern(5, 0, 0);

        System.out.println();
        int[][] arr = new int[8][8];
        halfTriangleNumberPattern(8, 0, 0, arr);

        System.out.println();
        int[] arr2 = new int[] { 1, 2, 4, 2, 1, 4, 1, 3, 8, 3, 7, 3, 1, 10 };
        System.out.println("Last Index Ok Key : " + lastIndexOfKey(arr2, arr2.length - 1, 4));

        System.out.println();
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println("Indices Of Key : " + indicesOfKey(arr2, 0, 4, ans));

        System.out.println();
        int[] arr3 = { 1, 2, 3, 3, 3, 2, 1 };
        System.out.println("Is Array Palindrome : " + isPalindrome(arr3, 0));

        System.out.println();
        System.out.println("Reverse An Array ");
        int[] result = reverseArr(arr2, 0);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
        ArrayList<String> subsequence = StringSubsequence("abcde", 0, new ArrayList<>());
        System.out.println("Sub Sequence " + subsequence + " , Length : " + subsequence.size());
        System.out.println();
        System.out.println("Subsequence 2 : ");
        StringSubsequence2("abc", 0, "");
        System.out.println();
        System.out.println("Number Letters Combinations");
        keyboardLetterCombinations("23", 0, "");

        System.out.println();
        System.out.println("LexicalOrder :");
        lexicalOrder(13, 0);

        System.out.println();
        System.out.println("Possible Ways To Reach a Location: ");
        System.out.println(" Total Ways : " + possibleWaysToTarget(3, 3, 0, 0, ""));
        System.out.println();

        String[] sort = { "cba", "bca", "acb", "abc", "cab", "bac" };

        // Arrays.sort(arr);
        // for(int i=0;i<sort.length;i++)
        // {
        // System.out.print(sort[i]+" ");
        // }

        System.out.println();
        System.out.println("Asci Subsequence ");
        int count = asciiSubsequence("ab", 0, "");
        System.out.println(" Asci Count : " + count);

        System.out.println();
        System.out.println("Array Subset Sum to Target ");
        int[] seq = {1,2,3,2,4,2};
        System.out.println("Total Subsets : "+subsetSumToTarget(seq,0,6,new ArrayList<>()));

        System.out.println();
        System.out.println("Person Ways to Go On Party : "+personPossibleWays(6));
        // int n = 3;

        // double length = Math.pow((double)2, (double)n);

        // String[][] subResult = new String[(int)length][3];

        // ArrayList<ArrayList<String>> subseq = new ArrayList<>();
        // subseq.add(s);

        // String sub = "ab";
        // ArrayList<String> s = new ArrayList<>();
        // s.add("");
        // for (int i = sub.length() - 1; i >= 0; i--) {
        // ArrayList<String> line = new ArrayList<>(s);
        // System.out.println("List : " + line + " " + line.size());

        // for (int j = 0; j < line.size(); j++) {
        // String st = (sub.charAt(i) + line.get(j)).trim();
        // System.out.println("Test : " + st+st.length());
        // s.add(st);
        // }
        // System.out.println(s);
        // }
        // System.out.println("Arraylist : " + s+ s.size());

        // int[] sub = { 1, 2,3};
        // ArrayList<Integer> s = new ArrayList<>();
        // ArrayList<Integer> next = new ArrayList<>();
        // next.add(0);
        // s.add(0);
        // for (int i = sub.length - 1; i >= 0; i--) {
        // ArrayList<Integer> line = new ArrayList<>(s);
        // System.out.println("List : " + line + " " + line.size());

        // for (int j = 0; j < line.size(); j++) {
        // int st = line.get(j) * 10 + sub[i] ;
        // System.out.print("Test : " + st);
        // int num = st;
        // int rev = 0;
        // while (num > 0) {
        // int rem = num % 10;
        // rev = rev * 10 + rem;
        // num = num / 10;
        // }
        // System.out.println(" "+rev);
        // next.add(rev);
        // s.add(st);

        // }
        // System.out.println(s);
        // }
        // System.out.println("Arraylist : " + s + s.size());
        // System.out.println("Arraylist : " + next + next.size());

        // int num = 4321;

        // int rev = 0;
        // while (num > 0)
        // {
        // int rem = num % 10;
        // rev = rev * 10 + rem;
        // num = num / 10;
        // }
        // System.out.println(rev);
    }

}

/**
 * Internship
 * 1 : Developed scalable REST APIs using Node.js and MongoDB aggregations for
 * admin dashboards and reports enabling dynamic filtering, cross-model data
 * joins, and efficient analytics across large datasets.
 * 
 * 1.Developed scalable REST APIs using Node.js and dynamic MongoDB aggregations
 * for admin dashboards and reports, enabling filtered queries, cross-collection
 * joins,and analytics over bookings, users, and related data.
 * 
 * 2. Architected and implemented a configurable Tournament Management System
 * supporting multi-sports, score types (Cricket, Football, Best Of, Race Off)
 * and formats (Knockout, Round Robin, Double Elimination), including match
 * scheduling,score tracking, and player progression logic.
 * 
 * 3.Delivered responsive UI components with complete API integration
 * for tournament feeds and real-time stats, enhancing visibility for
 * users through optimized rendering and intuitive layouts.
 * 
 * 3 .Delivered responsive UI components with integrated APIs for tournament
 * feeds and real-time stats, optimized through controlled re-renders, efficient
 * search, and lazy loading.
 */

/*
 * Internship
 * 1. i have develop apis for the admin dashboard, where fetching data from
 * across different database models with dynamic filters and used mongo db
 * aggregation dynamically to fetch data in a structured manner
 * 2. i have design and developed a tournament module to manage tournaments of
 * Clubs and venue with other clubs based on the different format like knockout
 * , double elimination and round robbin and based on different sport and for
 * each tournament it has different sport types like best of , race of , cricket
 * and football
 * 3. In arranging the setup number of rounds and matches and assigning
 * participants and keep tracking their scores and level up in the play
 * brackets.
 * 4. Developed Ui and api integration of tournaments feed , overview and stats
 * based on the different score type like Cricket, football, best Of And Race
 * Off.
 */

/**
 * Experience :
 * Gamebeez :
 * 1. Optimizing dashboard apis , reports apis from different models and
 * increasing the fetching by 60% by using mongo db aggregation methods
 * 2. collaborate with team to keep update on the changes and api updates.
 * 3. tested apis with jest and done unit testing and integration testing
 * 4. integrated the apis
 * 5. design , developed and test the tournament module using jest
 * Strike :
 * 1. Integrated apis in e commerce kind of project in react using optimizing
 * the component re rendering. optimizing the search using debouncing technique,
 * and developed and integrated the entire cart page with payment integration
 * 2. optimize the apis and reduce the db calls and fetching more effectively
 * with aggregation and minimize the payload size to reduce the band with to
 * frontend.
 * 3. worked on authentication workflow with protected routes and operate
 * through usecontext when the screens loads.
 * Dispute :
 * 1. come across a workflow and lead a project to manage dispute by pulling
 * dispute details from webhook from payment gateways for the specific business
 * id in params where the merchant can multiple business
 * 2. Merchant has multiple business accounts individual selection from the list
 * of accounts after login or inside a dashboard to switch between accounts
 * 2.2 implement a round robbin algorithm to assigned the dispute to merchant
 * and analyst in cycle order and keep them updated with notifications and
 * implement cron jobs to notify the upcoming deadline dispute progress.
 * 2.3 implement rabbit mq to receive the dispute and sent back acknowledgment
 * to payment gateways and consume the dispute from queue and parse it with
 * adaptor to internal platform format and manage it.
 * 3. Tracking of disputes history , logs with contesting ,accepting and
 * management dispute workflow .
 * 4. merchant can add business analyst to gather information refactor that
 * dispute is valid or not and take appropriate measures, like submit, and
 * resubmit the disputes in internal dashboard cycle
 * 5. manager to manager dispute which are submitted and accept or reject with
 * appropriate feedback and with action required updates.
 * 6. accepting disputes to get download and submit to gateway by manager or
 * merchant itself.
 * 7. keeping the updates and change in status and data in dispute in dashboard
 * and notifying the respective coordinator with in dashboard notifications.
 * 8. tested apis using jest for unit and integration testing.
 */

/**
 * Built and integrated RESTful APIs for an admin dashboard using dynamic
 * MongoDB aggregations
 * to fetch and filter data efficiently across multiple collections.
 * 
 * Developed REST APIs and dynamic MongoDB aggregations
 * for admin dashboards with advanced filtering across multiple collections
 * 
 * Built and integrated RESTful APIs for the admin dashboard using
 * dynamic MongoDB aggregations with filtering, pagination,
 * and cross-collection joins, optimizing payload size and query performance.
 * 
 * 
 * Developed scalable REST APIs using Node.js and MongoDB aggregations
 * for admin dashboards and reports enabling dynamic filtering,
 * cross-model data joins, and efficient analytics across large datasets.
 */

/**
 * 
 * 
 * 1. Architected a full-fledged dispute management system using PostgreSQL,
 * Sequelize, and RabbitMQ, with webhook ingestion, round-robin dispute
 * assignment, cron-based reminders, and real-time dashboard updates with
 * role-based workflows.
 * 2. Built scalable UI components integrated apis in React including ecommerce
 * cart/payment workflows, protected routes, and performance tuning via
 * debouncing, lazy loading, and controlled re-renders.
 * 3.Improved API performance by up to 60% using MongoDB aggregations, optimized
 * payloads, and modularized business logic to streamline data fetching and
 * reduce frontend load time.
 * 4.Ensured code quality and reliability through unit and integration testing
 * using Jest and Supertest, and mocked third-party services for isolated,
 * repeatable test environments.
 * 
 * 
 * Software Developer
 * Gamebeez — [Month Year – Present]
 * 
 * 1.Architected a dispute management system using PostgreSQL, Sequelize, and
 * RabbitMQ, with webhook ingestion pulled from payment gateways, round-robin
 * assignment to analyst, cron jobs notification, state update notification, and
 * role-based dashboard workflows.
 * 
 * 2.Built scalable React UI components with API integration, including
 * cart/payment flows, route protection, and performance tuning using debouncing
 * , lazy loading, and controlled re-renders.
 * 
 * 3.Optimized API performance by 60% using MongoDB aggregations, modular logic,
 * and reduced payload sizes for faster frontend rendering.
 * 
 * 4.Maintained high code quality through unit/integration testing with Jest and
 * Supertest, including mocking of third-party services.
 * 
 * 
 * 1.Architected a dispute management system using PostgreSQL, Sequelize, and
 * RabbitMQ, featuring webhook ingestion from payment gateways, round-robin
 * analyst assignment, cron-based alerts, and role-based state update workflows.
 * 
 * 2.Developed scalable React UI components with integrated APIs, including
 * cart/payment flows, route protection, and performance optimizations using
 * debouncing, lazy loading, and controlled re-renders.
 * 
 * 3.Improved API performance by 60% through MongoDB aggregations, modular
 * business logic, and minimized payloads to enhance data fetch speed and
 * frontend efficiency.
 * 
 * 4.Ensured code reliability through unit and integration testing with Jest and
 * Supertest, including mocking of third-party services for isolated, repeatable
 * test coverage.
 */

/**
 * 1. User Two Factor Authentication , Role Based System with Permission based
 * access
 * 2. token based authentication
 * 3. Tournament Management System based on different formats ( knockout, double
 * elimination, round robbin) with multiple sports and score
 * type like ( Cricket, football, best Of , Race Of) , scheduling matches and
 * score tracking stats, with participant level progression logic.
 * 4.Scheduling on venues, and referee assigned to match,
 * 5.tracking scores based on score Type
 * 6.manually arrange participants into each round
 * 7.participant can be individual or team
 * 8.notification based on the activity of the participant in the scheduled
 * matches and scores
 */