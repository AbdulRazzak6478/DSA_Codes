class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n=arr.length,m=arr[0].length;
        int rowStart=0,rowEnd=n-1;
        int colStart=0,colEnd=m-1;
        while(rowStart<=rowEnd && colStart<=colEnd)
        {
            //colStart to colEnd =>rowstart
            // for top
            for(int col=colStart;col<=colEnd;col++)
            {
                list.add(arr[rowStart][col]);
            }
            //rowStart to rowEnd =>colEnd
            // for right
            for(int row=rowStart+1;row<=rowEnd;row++)
            {
                list.add(arr[row][colEnd]);
            }
            //colEnd to colStart =>rowEnd
            // for bottom
            for(int col=colEnd-1;col>=colStart;col--)
            {
                if(rowStart==rowEnd)
                {
                    break;
                }
                list.add(arr[rowEnd][col]);
            }
            //rowEnd to rowStart =>colStart
            // for left
            for(int row=rowEnd-1;row>=rowStart+1;row--)
            {
                 if(colStart==colEnd)
                {
                    break;
                }
                list.add(arr[row][colStart]);
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return list;
    }
}