import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class TwoPointers {
    // remove duplicated from sorted array
    public static int removeDuplicates1(int[] arr) {
        // Q.26
        // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
        int elements = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                arr[elements] = arr[i];
                elements++;
            }
        }

        return elements;

    }

    public static int[] twoSum(int[] numbers, int target) {
        // Q.167
        // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
        int low = 0;
        int n = numbers.length;
        int high = n - 1;
        int[] result = new int[2];
        System.out.println("Testing");

        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            }
            if (numbers[low] + numbers[high] < target) {
                low++;
            }
            if (numbers[low] + numbers[high] > target) {
                high--;
            }
        }
        return result;
    }

    public static int[] sortZeroAndOnes(int[] arr) {

        // Two Pointer approach

        int zero = 0;
        int n = arr.length;
        int one = n - 1;

        while (zero < one) {
            if (arr[zero] == 0) {
                zero++;
            } else {
                int temp = arr[zero];
                arr[zero] = arr[one];
                arr[one] = temp;
            }

            if (arr[one] == 1) {
                one--;
            } else {
                int temp = arr[zero];
                arr[zero] = arr[one];
                arr[one] = temp;
            }
        }

        return arr;

        // TC : O (N)
        // int zeros = 0;
        // for (int i = 0; i < arr.length; i++) {
        // if (arr[i] == 0) {
        // zeros++;
        // }
        // }
        // for (int i = 0; i < arr.length; i++) {
        // if (i < zeros) {
        // arr[i] = 0;
        // } else {
        // arr[i] = 1;
        // }
        // }

        // return arr;
    }

    public static int numRescueBoats(int[] people, int limit) {

        // Q. 881
        // https://leetcode.com/problems/boats-to-save-people/description/

        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;
        int boats = 0;
        while (i <= j) {
            boats++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }

        System.out.println("Total Boats : " + boats);

        return boats;
    }

    public static void nextPermutation(int[] nums) {
        // Q.31
        // https://leetcode.com/problems/next-permutation/description/

        // step 1 : Traverse From Last Number
        // Step 2 : find the smaller number then the before current one
        // Step 3 : Store the index and traverse back to last to find the just larger
        // number then the snammler number which we find
        // Step 4 : Swap with the just larger number
        // Step 5 : reverse the numbers after the swapped larger number
        int s = 0;
        int l = nums.length - 1;
        while (l > 0) {
            if (nums[l - 1] < nums[l]) {
                s = l - 1;
                break;
            }
            l--;
        }
        System.out.println(l + " " + s);
        if (l != 0) {
            int last = s;
            while (l < nums.length) {
                if (nums[s] >= nums[l]) {
                    int temp = nums[s];
                    nums[s] = nums[l - 1];
                    nums[l - 1] = temp;
                    s++;
                    break;
                }
                l++;
            }
            if (s == last) {
                int temp = nums[s];
                nums[s] = nums[l - 1];
                nums[l - 1] = temp;
                s++;
            }

        }
        l = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("Test : " + s + " " + l);
        while (s < l) {
            int temp = nums[s];
            nums[s] = nums[l];
            nums[l] = temp;
            s++;
            l--;
        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static int removeDuplicates(int[] nums) {
        // 0,0,1,1,1,1,2,3,3
        // Q.80
        // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
        int i = 0;
        int count = 1;
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
        System.out.println();
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            if (nums[j - 1] == nums[j]) {
                System.out.print(nums[j] + " ");
                count++;
            } else {
                if (count >= 2) {
                    nums[i + 1] = nums[j - 1];
                    nums[i + 2] = nums[j];
                    i += 2;
                    count = 1;
                } else {
                    nums[i + 1] = nums[j];
                    i++;
                    count = 1;
                }
            }
        }
        System.out.println("Inside : " + count + " " + i);
        if (count >= 2) {
            nums[i + 1] = nums[n - 1];
            i += 1;
        }
        // System.out.println("Total Duplicates : " + i);
        System.out.println();
        for (int k = 0; k < n; k++) {
            System.out.print(nums[k] + " ");
        }

        return i + 1;
    }

    public static void sortColors(int[] nums) {
        // Q.75
        // https://leetcode.com/problems/sort-colors/

        int i = 0;
        int ones = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] == 0) {
                nums[i] = 0;
                i++;
            } else if (nums[j] == 1) {
                ones++;
            }
        }
        for (int k = i; k < n; k++) {
            if (ones != 0) {
                nums[k] = 1;
                ones--;
            } else {
                nums[k] = 2;
            }
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        System.out.println(ans);

        // Sort

        // 1. loops
        // 2. Store the in hashmap to get when we want the remaining number
        // 3. Two Pointers

        // Sort The Array
        // Traverse over the array
        // two pinter iteration from next element of array to find triplet
        // Skip the number if already found in triplet

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int s = i + 1;
            int e = n - 1;
            int target = 0 - nums[i];
            System.out.println(s + " " + e + " " + target);
            while (s < e) {
                if (nums[s] + nums[e] == target) {
                    List<Integer> lt = new ArrayList<>();
                    lt.add(nums[i]);
                    lt.add(nums[s]);
                    lt.add(nums[e]);
                    ans.add(lt);
                    System.out.println("Unique Triplet : " + lt);
                    s++;
                    e--;
                    while (nums[s] == nums[s + 1]) {
                        s++;
                    }
                    while (nums[e] == nums[e - 1]) {
                        e--;
                    }
                } else if (nums[s] + nums[e] < target) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        return ans;

    }

    public static int threeSumClosest(int[] nums, int target) {
        int resultSum = nums[0] + nums[1] + nums[2];
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int s = i + 1;
            int e = n - 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    s++;
                } else {
                    e--;
                }
                int difference = Math.abs(sum - target);
                if (difference < ans) {
                    resultSum = sum;
                    ans = difference;
                }
            }
        }

        return resultSum;
    }

    public int numSubseq(int[] nums, int target) {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        Arrays.sort(nums);
        int[] powers = new int[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }

        int i = 0;
        int j = nums.length - 1;
        int result = 0;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                result = (result + powers[j - i]) % MOD;
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    // 2^31 - 1
    // target = 5
    // 1 * 1 + 2 * 2 =
    public static boolean judgeSquareSum(int c) {

        // Q. 633
        long l = (long) 0;
        if (c == 1 || c == 2)
            return true;
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            long sum = (long) l * l + (long) r * r;
            if (sum == c)
                return true;
            else if (sum < c)
                l++;
            else
                r--;
        }
        return false;

        // int[] powers = new int[(target/2)+1];
        // for (int i = 0; i < powers.length; i++) {
        // powers[i] = i * i;
        // }

        // int s = 0;
        // int e = powers.length - 1;
        // while (s <=e) {
        // int sum = powers[s] + powers[e];
        // if (sum == target)
        // return true;
        // else if (sum < target)
        // s++;
        // else
        // e--;
        // }
        // return false
    }

    public static int minPairSum(int[] nums) {
        // Q.1877
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }
        System.out.println("Max Length : " + maxNum);
        int[] temp = new int[maxNum + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] += 1;
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }

        int s = 0;
        int e = temp.length - 1;
        int ans = 0;
        while (s <= e) {
            while (s < e && temp[s] == 0)
                s++;
            while (s <= e && temp[e] == 0)
                e--;
            ans = Math.max(ans, s + e);
            temp[s] -= 1;
            temp[e] -= 1;
        }
        Arrays.sort(nums);
        System.out.println("Sorted");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        return ans;

        // Arrays.sort(nums);
        // int s = 0;
        // int e = nums.length - 1;
        // int ansPairSum = Integer.MIN_VALUE;

        // while (s < e) {
        // int sum = nums[s] + nums[e];
        // ansPairSum = Math.max(ansPairSum, sum);
        // s++;
        // e--;
        // }
        // return ansPairSum;
    }

    public static int threeSumMulti(int[] arr, int target) {

        Arrays.sort(arr);
        int mod = 1000000009;

        int tuples = 0;
        int n = arr.length;
        for (int i = 0; i < n-2; i++) {
            int s = i + 1;
            int e = n - 1;

            while (s < e) {
                int sum = (arr[i] + arr[s] + arr[e]) % mod;
                if (sum == target) {
                    tuples++;
                    e--;
                } else if (sum < target)
                    s++;
                else
                    e--;
            }
        }
        return tuples;

        

    }

    public static void main(String[] args) {

        // int[] numbers = { 2, 5, 7, 8, 9, 12, 15 };
        // int target = 11;

        // int[] arr = twoSum(numbers, target);
        // System.out.println(arr[0] + " " + arr[1]);

        // int[] arr = { 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0 };

        // int[] result = sortZeroAndOnes(arr);
        // System.out.println("length : " + arr.length + " " + result.length);
        // for (int i = 0; i < result.length; i++) {
        // System.out.print(result[i] + " ");
        // }

        // int[] arr = { 1, 3, 2, 3, 1, 2, 2, 1, 3 };
        // // int[] arr = {1,2,3 };
        // int boats = numRescueBoats(arr, 3);

        // int [] arr = {4,6,8,7,6,5,3};
        // int[] arr = { 2, 2, 0, 4, 3, 1 };
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        // nextPermutation(arr);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // int[] arr = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        // int[] arr = {1,1,1,2,2,3};
        // int[] arr = {0,0,0,1,1,2,2,2,3,3,4,5,5};
        // int[] arr = {0,0,1,1,2,3,3};
        // System.out.println();
        // System.out.println("Total Duplicates :" +removeDuplicates(arr));

        // int[] arr = { 2, 1, 2, 1, 0, 0, 1, 2, 2, 1, 1, 0, 2 };
        // sortColors(arr);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // int[] arr = {-1,0,1,2,-1,-4};
        // List<List<Integer>> result = threeSum(arr);
        // System.out.println();
        // System.out.println("Array : "+result);
        // System.out.println(Integer.MIN_VALUE);

        // int[] arr = { -1, 2, 1, -4 };
        // int target = 1;
        // System.out.print("Target : " + target);
        // System.out.println();
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // int ans = threeSumClosest(arr, target);
        // System.out.println();
        // System.out.println("Closest : " + ans);

        // System.out.println("Sum Of Square Numbers : " + checkSumOfSquare(1000000));
        // System.out.println((long) 2147483646);
        // System.out.println(Math.sqrt(2147483646));
        // System.out.println((long) Math.sqrt(2147483646));

        // int[] arr = { 3, 5, 4, 2, 4, 6 };
        // int[] arr = { 9,2,10,1,10,4,8,9,7,6,8,10,8,6,5,4,3,4,2,10 };
        // int[] arr = { 4, 1, 5, 1, 2, 5, 1, 5, 5, 4 };

        // System.out.println("Max Pair sum : " + minPairSum(arr));


        int[] arr = {1,1,2,2,3,3,4,4,5,5};

        int ans =threeSumMulti(arr,8);
        System.out.println("Total Tuples :"+ans);

    }
}
