public static void Count_Sort(int arr[])
{
    // idea : Main a frequency array of array elements with the size of the 
    // max element of given array and traverse it .
    // TC : O(N)
    // SC : O(max element of given array)
    int n=arr.length;
    int large_ele=Integer.MIN_VALUE;
    for(int i=0;i<n;i++)
    {
        large_ele= arr[i]> large_ele ? arr[i] : large_ele;
    }
    int freguency_arr[]=new int[large_ele+1];
    for(int i=0;i<arr.length;i++)
    {
        freguency_arr[arr[i]]++;
    }
    int index=0;
    for(int i=0;i<freguency_arr.length;i++)
    {
        while(freguency_arr[i]>0)
        {
            arr[index]=i;
             index++;
            freguency_arr[i]--;
        }
    }
}