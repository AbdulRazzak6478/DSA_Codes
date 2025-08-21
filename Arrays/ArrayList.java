public class ArrayList {
    public static int removeElement(int[] nums, int val) {
        int element = 0;
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                newArr[element] = nums[i];
                element++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArr[i];
        }

        return element;

    }

    /*
     * nums = [0,1,2,2,3,0,4,2], val = 2
     */
    public static void main(String[] args) {
        System.out.println("ArrayList Section");
        // int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int[] nums = { 3,2,2,3 };
        int val = 3;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        int length = removeElement(nums, val);
        System.out.println("Value : " + length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
