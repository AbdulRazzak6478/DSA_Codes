 public static void Bubble_Sort(int arr[])
   {
        //idea : large element come to the end of the arrray by swapping with adjacent elements
        // (left > right) then swapp 
        // TC : O(N*2)
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j]>=arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
   }