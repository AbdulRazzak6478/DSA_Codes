class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder("");
         StringTopic str="";
        for(int i=0;i<chars.length;i++)
        {
            str+=chars[i];
        }
        Integer count=0;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1))
            {
                count++;
                i++;
            }
            sb.append(ch);
            if(count>1)
            {
                sb.append(count);
            }
        }
        for(int i=0;i<sb.length();i++)
        {
            chars[i]=sb.charAt(i);
        }
        return sb.length();



         //For subsequence appeariance
        // String str="aaaaabbbbcccc";
        // StringBuilder sb =new StringBuilder("");
        // int arr[]=new int[26];
        // for(int i=0;i<str.length();i++)
        // {
        //     int val=((int)str.charAt(i))-97;
        //     System.out.println(val);
        //     arr[val]=arr[val]+1;
        // }
        // for(int i=0;i<arr.length;i++)
        // {
        //     if(arr[i]>0) 
        //     {
        //         char ch=(char)(97+i);
        //         sb.append(ch);
        //         if(arr[i]>1)
        //         {
        //             ch=(char)(arr[i]+48);
        //             sb.append(ch);
        //         }
        //     }
        // }
        // System.out.println("Compress String is : "+sb);
        
    }
}