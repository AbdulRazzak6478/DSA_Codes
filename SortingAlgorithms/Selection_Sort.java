public static void Selection_Sort(int arr[])
{
    // idea : pick the smallest(from unsorted array ) put it in the beginning
    // TC : O(N*2)
    int n=arr.length;
    for(int i=0;i<n;i++)
    {
        int minPos=i;
        for(int j=i+1;j<n;j++)
        {
            if(arr[minPos]>arr[j])
            {
                minPos=j;
            }
        }
        int temp=arr[i];
        arr[i]=arr[minPos];
        arr[minPos]=temp;
    }
}