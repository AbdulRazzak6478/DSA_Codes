class Solution {
    public void BinaryStrings(int n,int lastPlace,String str)
    {
        if(n==0){
            System.out.println(str);
            return;
        }
        BinaryStrings(n-1, 0, str+"0");
        BinaryStrings(n-1, 1, str+"1");
    }
   
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans= new StringBuilder();                  
        for(int i=0; i<nums.length; i++)  
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');            
          // Using ternary operator
        return ans.toString();
    }
}