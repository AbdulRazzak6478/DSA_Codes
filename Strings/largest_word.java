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