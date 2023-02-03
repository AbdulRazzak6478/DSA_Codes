class Solution {
    public boolean isPalindrome1(String s) {
           // convert Strign s to lowerCase with regex
        String tempString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(tempString);
        // Reverse the tempString 
        String rev = new StringBuffer(tempString).reverse().toString();
        // check tempString to rev String 
        return tempString.equals(rev);
    }
    public boolean isPalindrome(String s) {
        String str="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) >= 'A' && s.charAt(i)<='Z')
                str+=s.charAt(i);
            else if(s.charAt(i) >= 'a' && s.charAt(i)<='z')
                str+=s.charAt(i);
            else if(s.charAt(i)>='0' && s.charAt(i)<='9')
                str+=s.charAt(i);
        }
        int ch=(int)'_';
        System.out.println(ch);
        
        str=str.toLowerCase();
        System.out.println(str);
        String res="";
        for(int i=str.length()-1;i>=0;i--)
        {
            res+=str.charAt(i);
        }
        System.out.println(res);
        
        return str.equals(res);
    }
}