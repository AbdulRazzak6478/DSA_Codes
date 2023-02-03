public static void Insertion_Sort(int arr[])
{
    // idea : pick an element (from unsorted array) and place in the right position in sorted part
    // TC : O(N*2)
    int n=arr.length;
    for(int i=1;i<n;i++)
    {
        int curr=arr[i];
        int prev=i-1;
        while(prev>=0 && arr[prev]>=curr)
        {
               arr[prev+1]=arr[prev];
            prev--;
        }
        arr[prev+1]=curr;
    }
}