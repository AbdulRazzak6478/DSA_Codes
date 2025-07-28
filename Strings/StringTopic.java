import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringTopic {

    public static int maxLengthBetweenEqualCharacters(String s) {
        // Q. 1624
        int maxLength = -1;

        int[] indices = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (indices[idx] != 0) {
                int length = i - indices[idx];
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                indices[idx] = i + 1;
            }
        }

        return maxLength;

        // TC : O(N)
        // SC : O (26)
        // int maxLength = -1;
        // int[] indices = new int[26];

        // for (int i = 0; i < s.length(); i++) {
        // char ch = s.charAt(i);
        // int asciiIndex = ((int) ch) - 97;
        // indices[asciiIndex] = i;
        // }
        // for (int i = 0; i < s.length(); i++) {
        // char ch = s.charAt(i);
        // int asciiIndex = ((int) ch) - 97;
        // if (indices[asciiIndex] != i) {
        // int length = indices[asciiIndex] - i - 1;
        // if (maxLength < length) {
        // maxLength = length;
        // }
        // }
        // }

        // return maxLength;
    }

    public static String reverseWords(String s) {
        // Q. 151
        // Ex: "the sky is blue", " hello world "

        s = s.trim();
        List<String> result = Arrays.asList(s.split("\\s+"));

        Collections.reverse(result);

        return String.join(" ", result);

        // StringBuilder result = new StringBuilder("");
        // StringBuilder temp = new StringBuilder("");
        // int start = 0;
        // int end = 0;
        // for (int i = s.length() - 1; i >= 0; i--) {
        // if (s.charAt(i) == ' ' && i == s.length() - 1)
        // continue;

        // if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {

        // result.append(temp.reverse()+" ");
        // temp.replace(0,end,"");
        // end = 0;
        // }
        // if(s.charAt(i) != ' ')
        // {
        // end++;
        // temp.append(s.charAt(i));
        // }
        // }
        // int len = result.length() - 1;
        // if(result.charAt(len) == ' ')
        // {
        // result.replace(len,len+1, "");
        // }
        // System.out.println("Result : 1"+result+"h");

        // return result.toString();
    }

    public static boolean isPalindrome(String s) {
        // Q. 125

        // 1
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        System.out.println(s);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

        // 2 -- Optimise One
        // for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
        // while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
        // i++;
        // while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
        // j--;

        // if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
        // {
        // return false;
        // }
        // }
        // return true;

        // 3
        // StringBuilder str = new StringBuilder("");
        // int idx = 0;
        // for (int i = 0; i < s.length(); i++) {
        // int ch = (int) s.charAt(i);
        // System.out.println(ch + " " + (char) ch);
        // if (ch >= 65 && ch <= 90) {
        // ch += 32;
        // str.append((char) ch);
        // idx++;
        // } else if (ch >= 97 && ch <= 122) {
        // str.append((char) ch);
        // }
        // }
        // System.out.println(str);
        // for (int i = 0; i < str.length(); i++) {
        // if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        // return false;
        // }
        // }

        // return true;
    }

    public static String largestOddNumber(String num) {
        // Q. 1903
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static String customSortString(String order, String s) {
        // Q.791

        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int i=0; i<s.length(); i++) {
        // map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // }
        // StringBuilder str = new StringBuilder("");
        // for (int i=0; i<order.length(); i++) {
        // char ch = order.charAt(i);
        // if (map.containsKey(ch)) {
        // int count = map.get(ch);
        // for (int j=0; j<count; j++) {
        // str.append(ch);
        // }
        // map.remove(ch);
        // }
        // }
        // if (map.size() != 0) {
        // for (char key : map.keySet()) {
        // int count = map.get(key);
        // for (int j=0; j<count; j++) {
        // str.append(key);
        // }
        // }
        // }
        // return str.toString();

        // TC : O(2N)
        // SC : O(N+26)
        // Better
        StringBuilder str = new StringBuilder("");
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = order.indexOf(s.charAt(i));
            if (idx == -1) {
                str.append(s.charAt(i));
            }
            int ch = s.charAt(i) - 97;
            counts[ch]++;
        }
        for (int i = order.length() - 1; i >= 0; i--) {
            int ch = counts[order.charAt(i) - 97];
            while (ch > 0) {
                str.insert(0, order.charAt(i));
                ch--;
            }

        }

        return str.toString();
    }

    public static String reverseOnlyLetters(String s) {
        // Q.917
        // int i = 0;
        // int j = s.length() - 1;
        // StringBuilder str = new StringBuilder(s);
        // while (i < j) {
        // while (i < j && !Character.isLetter(str.charAt(i)))
        // i++;
        // while (i < j && !Character.isLetter(str.charAt(j)))
        // j--;

        // char ch = str.charAt(i);
        // str.setCharAt(i, str.charAt(j));
        // str.setCharAt(j, ch);
        // i++;
        // j--;
        // }

        // return str.toString();

        char[] chars = s.toCharArray();
        int first = 0;
        int last = s.length() - 1;
        while (first < last) {
            if (!Character.isAlphabetic(chars[first])) {
                first++;
            } else if (!Character.isAlphabetic(chars[last])) {
                last--;
            } else {
                char c = s.charAt(first);
                chars[first] = chars[last];
                chars[last] = c;
                first++;
                last--;
            }
        }
        return new String(chars);
    }

    public static int removeElement(int[] nums, int val) {
        // Q.27

        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
        // TC : O(N)
        // SC : O(1)
        // int i=0;
        // for(int j=0;j<nums.length;j++)
        // {
        // if(val != nums[j])
        // {
        // int temp = nums[i];
        // nums[i] = nums[j];
        // nums[j] = temp;
        // i++;
        // }
        // }

        // return i;

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

    public static boolean checkPalindromeFormation(String a, String b) {
        // Q.1616
        if (a.length() == 1 && b.length() == 1) {
            return true;
        }

        int n = a.length();
        if (a.charAt(0) == b.charAt(n - 1)) {
            return true;
        }
        if (a.charAt(n - 1) == b.charAt(0)) {
            return true;
        }

        return false;
        // class Solution {
        // static {
        // for (int i = 0; i < 300; i++) {
        // checkPalindromeFormation("","");
        // }
        // }
        // public static boolean checkPalindromeFormation(String a, String b) {
        // int n = a.length();
        // if (n == 1) return true;
        // return check(a,b,n) || check(b,a,n);
        // }
        // private static boolean check(String a, String b, int n) {
        // int j = 0;
        // while (j+j < n && a.charAt(j) == b.charAt(n-j-1)) {
        // j++;
        // }
        // if (j+j == n) return true;
        // int l = j;
        // int k = n-j-1;
        // while (j <= k && a.charAt(j) == a.charAt(k)) {
        // j++;
        // k--;
        // }
        // if (j > k) return true;

        // j = l;
        // k = n-j-1;
        // while (j <= k && b.charAt(j) == b.charAt(k)) {
        // j++;
        // k--;
        // }
        // if (j > k) return true;

        // return false;
        // }
        // }

        // class Solution {
        // public boolean checkPalindromeFormation(String a, String b) {
        // return validate(a, b) || validate(b, a);
        // }

        // public boolean validate(String a, String b) {
        // int i = 0;
        // int j = a.length() - 1;
        // for (i = 0; i <= j; i++, j--) {
        // if (a.charAt(i) != b.charAt(j)) {
        // break;
        // }
        // }

        // return isPalindrome(a, i, j) || isPalindrome(b, i, j);
        // }

        // public boolean isPalindrome(String s, int l, int r) {
        // int i, j;
        // for (i = l, j = r; i <= j; i++, j--) {
        // if (s.charAt(i) != s.charAt(j)) {
        // return false;
        // }
        // }
        // return true;
        // }
        // }
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // Q.833

        /*
         * private boolean isValid(String s, int idx, String sub){
         * if (s.length() - idx < sub.length()) return false;
         * 
         * return s.substring(idx, idx + sub.length()).equals(sub);
         * }
         * 
         * public String findReplaceString(String s, int[] indices, String[] sources,
         * String[] targets) {
         * int[] changed = new int[s.length()];
         * Arrays.fill(changed, -1);
         * 
         * for (int i = 0; i < indices.length; i++){
         * if (isValid(s, indices[i], sources[i])){
         * changed[indices[i]] = i;
         * }
         * }
         * 
         * StringBuilder ans = new StringBuilder();
         * for (int i = 0; i < s.length(); i++){
         * if (changed[i] == -1){
         * ans.append(s.charAt(i));
         * } else {
         * ans.append(targets[changed[i]]);
         * i += sources[changed[i]].length() - 1;
         * }
         * }
         * 
         * return ans.toString();
         * }
         */
        int n = indices.length;

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> indices[b] - indices[a]);

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            int idx = indices[order[i]];
            String src = sources[order[i]];
            String tgt = targets[order[i]];

            if (idx + src.length() <= s.length() && s.substring(idx, idx + src.length()).equals(src)) {
                sb.replace(idx, idx + src.length(), tgt);
            }
        }

        return sb.toString();

        // HashMap<Integer, List<List<String>>> map = new HashMap<>();
        // for (int i=0; i<indices.length; i++) {
        // if (!map.containsKey(indices[i])) {
        // List<List<String>> ans = new ArrayList<>();
        // List<String> list = new ArrayList<>();
        // list.add(sources[i]);
        // list.add(targets[i]);
        // ans.add(new ArrayList<>(list));
        // map.put(indices[i], ans);
        // }
        // else {
        // List<List<String>> ans = map.get(indices[i]);
        // List<String> list = new ArrayList<>();
        // list.add(sources[i]);
        // list.add(targets[i]);
        // ans.add(new ArrayList<>(list));
        // map.put(indices[i], ans);
        // }
        // }
        // StringBuilder str = new StringBuilder("");
        // int i = 0;
        // while (i < s.length()) {
        // if (map.containsKey(i)) {
        // List<List<String>> list = map.get(i);
        // boolean flag = true;
        // for (int j=0; j<list.size(); j++) {
        // List<String> li = list.get(j);
        // int n = li.get(0).length();
        // if (i+n <= s.length() && s.substring(i, i+n).equals(li.get(0))) {
        // str.append(li.get(1));
        // i += n;
        // flag = false;
        // break;
        // }
        // }
        // if (flag) {
        // str.append(s.charAt(i));
        // i++;
        // }
        // }
        // else {
        // str.append(s.charAt(i));
        // i++;
        // }
        // }
        // return str.toString();

        // StringBuilder str = new StringBuilder(s);
        // for (int i = 0; i < indices.length; i++) {
        // String st = sources[i];
        // String e = targets[i];
        // // System.out.print("s");
        // if (indices[i] + st.length() > s.length())
        // continue;
        // String val = s.substring(indices[i], indices[i] + st.length());
        // System.out.println(st + " " + val);
        // if (st.equals(val)) {
        // int idx = str.indexOf(st);
        // if (idx == -1) {
        // str.replace(str.length() - 1, str.length(), e);
        // } else {

        // str.replace(idx, idx + st.length(), e);
        // }
        // }
        // }
        // return str.toString();
    }


    public static void largestWord() {
    String str = "hello, i am abdulrazzak ";
    StringBuilder sb = new StringBuilder("");
    int start = 0, left = 0;
    int end = 0;
    int maxLength = Integer.MIN_VALUE;
    start++;
    for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == ' ' && i < str.length() - 1) {
            int length = end - start;
            if (maxLength <= length) {
                maxLength = length;
                left = start;
                start = i + 1;
                end = i + 1;
            } else {
                start = i + 1;
                end = i + 1;
            }
        } else {
            end++;
        }
    }
    for (int i = 0; i < maxLength; i++) {
        sb.append(str.charAt(left + i));
    }
    System.out.println("Length of the word is  : " + maxLength);
    System.out.println(sb);
    System.out.println("Testing");
}
    public static void main(String[] args) {
        System.out.println("String & StringBuilder ");
        System.out.println();

        // StringBuilder str = new StringBuilder("abcdfghbkawwb");
        // StringBuilder str = new StringBuilder("abcdfghbkawwb");
        // System.out.println(str.reverse() + " " + str.insert(0, 's'));
        // System.out.println("Max Length : " + (maxLength - 1));

        // System.out.println(reverseWords(" hello world "));
        // System.out.println((char) (78) + " " + (char) (78 + 32));

        // System.out.println("IsPalendrome : "+isPalindrome("A man, a plan, a canal:
        // Panama"));

        // String s = "123455";
        // System.out.println(s.replace("23", "32"));

        // System.out.println(" Test : " + customSortString("asdfg", "asjfkaispsdlef"));

        // System.out.println("Reverse Only Letters : " + reverseOnlyLetters("ab-cd"));
        // System.out.println("Reverse Only Letters : " +
        // reverseOnlyLetters("a-bC-dEf-ghIj"));
        // System.out.println("Reverse Only Letters : " +
        // reverseOnlyLetters("Test1ng-Leet=code-Q!"));

        // int[] num = {0,1,2,2,3,0,4,2};
        // int[] num = {3,2,2,3,5,3,2,5,6,8,9,12,3,47,89,43,2,4,5,6,7,8,9};
        // int[] num = { 1, 2, 3, 4, 6, 7, 8, 9, 0 };
        // System.out.println("Remove Element : " + removeElement(num, 5));
        // for (int i = 0; i < num.length; i++) {
        // System.out.print(num[i] + " ");
        // }
        // System.out.println();

        // System.out.println("Check Two Palindrome Strings :
        // "+checkPalindromeFormation("x","y"));
        // System.out.println("Check Two Palindrome Strings :
        // "+checkPalindromeFormation("xbdef","xecab"));
        // System.out.println("Check Two Palindrome Strings :
        // "+checkPalindromeFormation("ulacfd","jizalu"));

        // String s = "jjievdtjfb";
        // int[] indices = { 4, 6, 1 };
        // String[] sources = { "md", "tjgb", "jf" };
        // String[] targets = { "foe", "oov", "e" };

        // String s = "abcd";
        // int[] indices = {0, 2};
        // String[] sources = {"ab","ec"};
        // String[] targets = {"eee","ffff"};

        // String s = "abcd";
        // int[] indices = {0, 2};
        // String[] sources = {"a","cd"};
        // String[] targets = {"eee","ffff"};
        // String s = "abcde";
        // int[] indices = { 2, 2, 3 };
        // String[] sources = { "cde", "cdef", "dk" };
        // String[] targets = { "fe", "f", "xyz" };

    }
}
