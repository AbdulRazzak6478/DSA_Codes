import java.util.ArrayList;

public class ArrayLeetCode {
    public static int removeElement(int[] nums, int val) {
        // TC : O(N)
        // SC : O(1)
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (val != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return i;

        // TC : O(N)
        // SC : O(N)
        // int element = 0;
        // int[] newArr = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // if (val != nums[i]) {
        // newArr[element] = nums[i];
        // element++;
        // }
        // }
        // for (int i = 0; i < nums.length; i++) {
        // nums[i] = newArr[i];
        // }

        // return element;

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> newArr = new ArrayList<>();
        int l1 = 0;
        int l2 = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] == nums2[l2]) {
                newArr.add(nums1[l1]);
                l1++;
                l2++;
            } else if (nums1[l1] < nums2[l2]) {
                l1++;
            } else {
                l2++;
            }
        }
        int[] arr = new int[newArr.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr.get(i);
            System.out.print(arr[i] + " ");
        }

        return arr;
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        return dividend / divisor;

    }

    public static int maxArea(int[] height) {
        // {1,8,6,2,5,4,8,3,7}
        // 49

        // TC : O(N)
        // SC : O(1)
        int n = height.length;

        int ans = 0, l = 0, r = n - 1;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            int len = r - l;
            ans = Math.max(ans, min * len);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static int trap(int[] height) {
        // TC: O(N)
        // SC:O(1)
        int n = height.length;
        int res = 0, l = 0, r = n - 1;
        int maxWater = 0;
        // for corner cases
        if (height.length == 1 || height.length == 2) {
            return maxWater;
        }
        int lmax = height[l], rmax = height[r];
        while (l < r) {
            if (lmax < rmax) {
                l++;
                lmax = Math.max(lmax, height[l]);
                res += lmax - height[l];
            } else {
                r--;
                rmax = Math.max(rmax, height[r]);
                res += rmax - height[r];
            }
        }
        return res;

        // TC : O(N)
        // SC : o(2N)
        // Left Sum Array and right sum Array
        // int[] leftMaxSum = new int[height.length];
        // int[] rightMaxSum = new int[height.length];

        // int n = height.length;
        // int maxWater = 0;
        // if (n == 1 || n == 2)
        // return maxWater;

        // leftMaxSum[0] = height[0];
        // // Left of the Array
        // rightMaxSum[n - 1] = height[n - 1];
        // for (int i = 1; i < n; i++) {
        // leftMaxSum[i] = Math.max(leftMaxSum[i - 1], height[i]);
        // }
        // // right Sum Array
        // for (int i = n - 2; i >= 0; i--) {
        // rightMaxSum[i] = Math.max(rightMaxSum[i + 1], height[i]);
        // }

        // // trap from high to low then trap the water
        // for (int i = 0; i < n; i++) {
        // int maxHeight = Math.min(leftMaxSum[i], rightMaxSum[i]);

        // maxWater += maxHeight - height[i];
        // }

        // return maxWater;
    }

    public static void main(StringTopic[] args) {
        System.out.println("Array LeetCode Questions");

        // int[] num1 = { 1, 2, 2, 3, 6 };
        // int[] num2 = { 2, 6, 7, 9, 2 };
        // int[] nums1 = { 4, 6, 9 };
        // int[] nums2 = { 4, 6, 7, 9 };

        // int[] result = intersection(nums1, nums2);

        // System.out.println(divide(-2147483648, -1));

        System.out.println("Rain Water Trapping");
        // int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int[] height = { 1,8,6,2,5,4,8,3,7};
        int[] height = {1,1,3,2,4,1};

        // System.out.println("Train Water Trapped : " + trap(height));
        System.out.println("Train Water Trapped : " + maxArea(height));
    }
}
