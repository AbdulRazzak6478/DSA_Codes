class Solution {
    public int diagonalSum(int[][] mat) {
        //TC: O(N)
        int sum=0;
        for(int i=0;i<mat.length;i++)
        {
            sum+=mat[i][i];
            if(i!=mat.length-1-i)
                sum+=mat[i][mat.length-1-i];
        }
        return sum;

        // // TC : O(N*M)
        // int sum=0;
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         if(i==j)
        //         {
        //             System.out.print(arr[i][j]+"+");
        //             sum+=arr[i][j];
        //         }
        //         else if(i+j==n-1)
        //         {
        //             System.out.print(arr[i][j]+"+");
        //             sum+=arr[i][j];
        //         }
        //     }
        // }
        // return sum;
    }
}