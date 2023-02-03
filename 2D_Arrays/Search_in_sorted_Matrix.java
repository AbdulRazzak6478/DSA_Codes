class Solution {
    public int binarySearch(int arr[][],int r,int clength,int key)
    {
        int s=0,e=clength;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(arr[r][mid]==key)
                return mid;
            else if(arr[r][mid]<key)
                s=mid+1;
            else
                e=mid-1;
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        //top right
        // Staircase Search 
        // TC : O(N+M)
        int row=0,col=m-1;

        while(row <= n-1 && col >= 0)
        {
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;


        // //Row wise searching using BinarySearch
        // // TC : O(N*log(M))

        // for(int i=0;i<n;i++){
        //     int j=binarySearch(matrix,i,m-1,target);
        //     if(j>=0)
        //         return true;
        // }
        // return false;
    


        // //Brute Force
        // //TC: O(N*M)
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         if(matrix[i][j]==target)
        //         {
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
}