
import java.util.ArrayList;
import java.util.Scanner;

public class Array2D {

    public static int[][] inputArray() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Of Rows :");
        int r = sc.nextInt();
        System.out.println("Enter Number Of Columns :");
        int c = sc.nextInt();
        System.out.println("Enter Matrix : ");
        int[][] arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
            // System.out.println();
        }

        sc.close();

        return arr;
    }

    public static void output2DArray(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        System.out.println();
        System.out.println("Output Array");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printWaveOrder(int[][] arr) {
        // if column divisible by 2 then go down else up
        // if r == 0 then go to next column or if r == row -1 then change column

        // int r = arr.length;
        // int c = arr[0].length;
        // int rEnd = c % 2 == 0 ? 0 : r - 1;
        // int cEnd = c - 1;

        int r = 0;
        int c = 0;
        int rEnd = arr.length;
        int cEnd = arr[0].length;

        while (c < cEnd) {
            if (c % 2 == 0) {
                System.out.print(arr[r][c] + " ");
                if (r + 1 == rEnd) {
                    c++;
                } else {
                    r++;
                }
            } else {
                System.err.print(arr[r][c] + " ");
                if (r == 0) {
                    c++;
                } else {
                    r--;
                }
            }
        }
    }

    public static void transposeMatrix(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;
        int[][] result = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = arr[i][j];
            }
        }

        output2DArray(arr);
        output2DArray(result);

    }

    public static void multiplicationMatrix(int[][] arr1, int[][] arr2) {

        int r1 = arr1.length;
        int r2 = arr2.length;

        // int c1 = arr1[0].length;
        int c2 = arr2[0].length;

        if (r1 != c2) {
            System.out.println("InValid Matrix length");
            return;
        }

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < r2; k++) {
                    sum += (arr1[i][k] * arr2[k][j]);
                }
                System.out.println(sum + " ");
                result[i][j] = sum;
            }
        }

        output2DArray(result);

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        // Storing the values of mat matrix
        // i.e m = rows & n = cols
        int rows = mat.length;
        int columns = mat[0].length;
        // if the product of rows & cols of mat matrix and the new matrix are not same
        // then return original matri
        if ((rows * columns) != (r * c)) {
            return mat;
        }

        int[][] result = new int[r][c];
        int row = 0;
        int column = 0;
        // Traversing the mat matrix and storing the its values in new matrix output
        // cols wise
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                result[row][column] = mat[i][j];
                column++;
                // if the cols value reached then change the row and set the cols value to 0.
                if (column == c) {
                    row++;
                    column = 0;
                }
            }
        }

        return result;
    }

    public static int maximumWealth(int[][] accounts) {

        int maxWealth = Integer.MIN_VALUE;

        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > maxWealth) {
                maxWealth = sum;
            }
            // maxWealth = Math.max(sum, maxWealth);
        }

        return maxWealth;
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (matrix[i][j] != matrix[i - 1][j - 1]) {
                        return false;
                    }
                }
                if (i + 1 < rows && j + 1 < columns) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public static int diagonalSum(int[][] mat) {

        int diagonalSum = 0;
        int rows = mat.length;
        int r = 0;
        int c = 0;
        while (r < rows && c < rows) {
            diagonalSum += mat[r][c];
            if (rows - 1 - r != r) {
                diagonalSum += mat[rows - 1 - r][c];
            }
            r++;
            c++;
        }

        return diagonalSum;

    }

    public static int countNegatives(int[][] grid) {

        // TC : O(N + M)
        // SC : O(1)

        int rows = grid.length;
        int columns = grid[0].length;
        int count = 0;

        int i = 0;
        int j = columns - 1;
        while (j >= 0 && i < rows) {
            if (grid[i][j] < 0) {
                count += (rows - i);
                j--;
            } else {
                i++;
            }
        }

        return count;

        // TC : O(N * M)
        // SC : O(1)
        // int count = 0;
        // for(int i=0;i<grid.length;i++)
        // {
        // for(int j=0;j<grid[i].length;j++)
        // {
        // if(grid[i][j] < 0)
        // {
        // count++;
        // }
        // }
        // }
        // return count;
    }

    public static int[][] setMatrixZero(int[][] arr) {

        int n = arr.length;
        boolean isRow = false;
        boolean isColumn = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                    if (i == 0)
                        isRow = true;
                    if (j == 0)
                        isColumn = true;
                }
            }
        }
        output2DArray(arr);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[0][j] == 0 || arr[i][0] == 0) {
                    arr[i][j] = 0;
                }
            }
        }
        output2DArray(arr);

        System.out.println(isRow);
        System.out.println(isColumn);
        if (isRow) {
            for (int i = 0; i < n; i++) {
                arr[0][i] = 0;
            }
        }
        if (isColumn) {
            for (int i = 0; i < n; i++) {
                arr[i][0] = 0;
            }
        }

        return arr;

        // { 1, 2, 3, 0 },
        // { 5, 6, 7, 8 },
        // { 9, 0, 11, 12 },
        // { 13, 14, 10, 16 }

        // TC : O(M*N)
        // SC : O(M+N)
        // Store the rows and columns in which we need to add zeros
        // iterate and when we comes to specific row or column which we mention in
        // separate respective array make that element zero

        // int r = arr.length;
        // int c = arr[0].length;
        // int[] rows = new int[r];
        // int[] columns = new int[c];

        // for (int i = 0; i < r; i++) {
        // for (int j = 0; j < c; j++) {
        // if (arr[i][j] == 0) {
        // rows[i] = 1;
        // columns[j] = 1;
        // }
        // }
        // }
        // for (int i = 0; i < rows.length; i++) {
        // System.out.print(rows[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < columns.length; i++) {
        // System.out.print(columns[i] + " ");
        // }
        // System.out.println();
        // for (int i = 0; i < r; i++) {
        // for (int j = 0; j < c; j++) {
        // if (rows[i] == 1) {
        // arr[i][j] = 0;
        // }
        // if (columns[j] == 1) {
        // arr[i][j] = 0;
        // }
        // }
        // }

        // return arr;
    }

    public static int[][] matrixRotateImage(int[][] arr) {

        // For making rotate clock wise
        // 1. Iterate and swap 1st and last row
        // 2. Transpose the matrix

        // For making rotate in anticlockwise
        // 1. Iterate and swap 1st and last column
        // 2. Transpose the matrix

        int n = arr.length;

        // Clockwise

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - i - 1][j];
                arr[n - i - 1][j] = temp;
            }
        }
        // output2DArray(arr);
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = result[i][j];
            }
        }
        output2DArray(arr);

        return result;
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = m - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            // Traverse row -> col start to end
            for (int i = colStart; i <= colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {

                for (int i = colEnd; i >= colStart; i--) {
                    list.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {

                for (int i = rowEnd; i >= rowStart; i--) {
                    list.add(matrix[i][colStart]);
                }
                colStart++;
            }

        }

        // System.out.println("Spiral Order : " + list);
        return list;

    }

    public static int[][] spiralMatrix3(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[][] ans = new int[rows][cols];
        ans[rStart][cStart] = 1;
        int dimension = 0;
        int totalVisits = rows * cols;
        int visits = 1;
        result[0][0] = rStart;
        result[0][1] = cStart;

        while (visits < totalVisits) {
            // Move Column right side

            // if(dimension == 7)
            // {
            // break;
            // }
            // System.out.print(dimension+" ");
            for (int i = 1; i <= dimension + 1; i++) {
                // System.out.println(rStart+" "+(cStart+i));
                if ((cStart + i < cols && cStart + i >= 0) && (rStart < rows && rStart >= 0)) {
                    result[visits][0] = rStart;
                    result[visits][1] = cStart + i;
                    visits++;
                    ans[rStart][cStart + i] = visits;
                }
            }
            cStart = cStart + dimension + 1;

            // move row down side
            for (int i = 1; i <= dimension + 1; i++) {
                // System.out.println((rStart + i)+" "+(cStart));
                if ((rStart + i < rows && rStart + i >= 0) && (cStart < cols && cStart >= 0)) {
                    result[visits][0] = rStart + i;
                    result[visits][1] = cStart;
                    visits++;
                    ans[rStart + i][cStart] = visits;
                }
            }
            rStart = rStart + dimension + 1;
            dimension++;

            // Move column left side
            for (int i = 1; i <= dimension + 1; i++) {
                // System.out.println((rStart)+" "+(cStart - i));
                if ((cStart - i < cols && cStart - i >= 0) && (rStart < rows && rStart >= 0)) {
                    result[visits][0] = rStart;
                    result[visits][1] = cStart - i;
                    visits++;
                    ans[rStart][cStart - i] = visits;
                }
            }
            cStart = cStart - (dimension + 1);

            // Move to Row Top Side
            for (int i = 1; i <= dimension + 1; i++) {
                // System.out.println((rStart - i)+" "+(cStart));
                if ((rStart - i < rows && rStart - i >= 0) && (cStart < cols && cStart >= 0)) {
                    result[visits][0] = rStart - i;
                    result[visits][1] = cStart;
                    visits++;
                    ans[rStart - i][cStart] = visits;
                }
            }
            rStart -= dimension + 1;
            dimension++;

        }

        System.out.println("visits:" + visits);
        System.out.println("Spiral Array");
        output2DArray(ans);
        System.out.println("Coordinates : ");
        output2DArray(result);
        return result;
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int arr[][] = new int[image.length][image.length];
        int k = 0;

        for (int i = 0; i < image.length; i++) {
            for (int j = image.length - 1; j >= 0; j--) {
                if (image[i][j] == 1)
                    arr[i][k++] = 0;
                else
                    arr[i][k++] = 1;
            }
            k = 0;
        }
        return arr;

        // int n = image.length;

        // // Flip the All Rows
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j <=n / 2; j++) {
        // if (j != n / 2) {
        // int temp = image[i][j];
        // image[i][j] = image[i][n - 1 - j] == 0 ? 1 : 0;
        // image[i][n - 1 - j] = temp == 0 ? 1 : 0;
        // }
        // if (n % 2 != 0 && j == n / 2) {
        // image[i][j] = image[i][j] == 0 ? 1 : 0;
        // }
        // }
        // }

        // return image;
    }

    public static String tictactoe(int[][] moves) {

        String[][] ans = new String[3][3];

        for (int i = 0; i < moves.length; i++) {
            ans[moves[i][0]][moves[i][1]] = i % 2 == 0 ? "X" : "O";
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ans[i][j] == null) {
                    ans[i][j] = " ";
                }
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        String winner = "Draw";
        int playerA = 0;
        int playerB = 0;
        boolean isWinner = false;

        // For Rows
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                if (ans[i][j] == " ")
                    break;
                if (ans[i][j] == "X")
                    playerA++;

                if (ans[i][j] == "O")
                    playerB++;

            }
            if (playerB == 3) {
                winner = "B";
                isWinner = true;
            }
            if (playerA == 3) {
                isWinner = true;
                winner = "A";
            }
            if (isWinner)
                break;

            playerA = 0;
            playerB = 0;

            for (int j = 0; j < 3; j++) {
                if (ans[j][i] == " ")
                    break;
                if (ans[j][i] == "X")
                    playerA++;

                if (ans[j][i] == "O")
                    playerB++;
            }
            if (playerB == 3) {
                winner = "B";
                isWinner = true;
            }
            if (playerA == 3) {
                isWinner = true;
                winner = "A";
            }
            if (isWinner)
                break;

            playerA = 0;
            playerB = 0;
        }

        if (!isWinner) {
            for (int i = 0; i < 3; i++) {
                if (ans[i][i] == " ")
                    break;
                if (ans[i][i] == "X")
                    playerA++;

                if (ans[i][i] == "O")
                    playerB++;
            }
            if (playerB == 3) {
                winner = "B";
                isWinner = true;
            }
            if (playerA == 3) {
                isWinner = true;
                winner = "A";
            }

            playerA = 0;
            playerB = 0;

            if (!isWinner) {
                for (int i = 2; i >= 0; i--) {
                    if (ans[2 - i][i] == " ")
                        break;
                    if (ans[2 - i][i] == "X")
                        playerA++;

                    if (ans[2 - i][i] == "O")
                        playerB++;

                    System.out.println(playerA+" "+playerB);
                }
                if (playerB == 3) {
                    winner = "B";
                    isWinner = true;
                }
                if (playerA == 3) {
                    isWinner = true;
                    winner = "A";
                }
            }
        }


        if(!isWinner)
        {
            for(int i =0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(ans[i][j] == " ")
                    {
                        return "Pending";
                    }
                }
            }
        }
        return winner;
    }

    public static void main(String[] args) {

        System.out.println("2D Arrays Practice ");

        // int[][] arr = inputArray();

        // output2DArray(arr);

        // System.out.println("wave Order Matrix");
        // int[][] arr = {
        // { 1, 2, 3, 4, 5 },
        // { 5, 6, 7, 8, 6 },
        // { 9, 10, 11, 12, 7 },
        // { 13, 14, 15, 16, 8 }
        // };

        // System.out.println("Print Wave Matrix");
        // printWaveOrder(arr);

        // System.out.println("Transpose Matrix");
        // transposeMatrix(arr);

        // int[][] arr1 = {
        // { 1, 2, 3 },
        // { 4, 5, 7 }
        // };

        // int[][] arr2 = {
        // { 1, 2, 5 },
        // { 4, 5, 6 },
        // { 8, 9, 7 }
        // };

        // multiplicationMatrix(arr1, arr2);
        // System.out.println("Sum : " + diagonalSum(arr2));

        // int[][] grid = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1,
        // -1, -2, -3 } };

        // System.out.println("Count Negatives : " + countNegatives(grid));

        // int[][] matrix = {
        // { 1, 2, 3, 0 },
        // { 5, 6, 7, 8 },
        // { 9, 0, 4, 2 },
        // { 1, 7, 5, 8 }
        // };

        // int[][] result = setMatrixZero(matrix);

        // int[][] matrix = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 }
        // // { 13, 9, 5, 1 },
        // // { 14, 10, 6, 2 },
        // // { 15, 11, 7, 3 },
        // // { 16, 12, 8, 4 },
        // };
        // int[][] matrix = {
        // { 1, 2, 3 },
        // { 4, 5, 6 },
        // { 7, 8, 9 }
        // };
        // output2DArray(matrix);
        // int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        // int[][] result = matrixRotateImage(arr);
        // output2DArray(result);

        // int[][] arr = {
        // {1,2,3,4},
        // {5,6,7,8},
        // {9,10,11,12}
        // };
        // int[][] arr = {
        // { 1, 2, 3 },
        // { 4, 5, 6 },
        // { 7, 8, 9 }
        // };
        // ArrayList<Integer> list = spiralOrder(arr);

        // int[][] result = spiralMatrix3(1, 4, 0, 0);
        // int[][] result = spiralMatrix3(5, 6, 1, 4);

        // int[][] arr = {
        // { 1, 1, 0 },
        // { 1, 0, 1 },
        // { 0, 0, 0 }
        // };

        // int[][] result = flipAndInvertImage(arr);

        // int[][] arr = { { 0, 0 }, { 2, 0 }, { 1, 1 }, { 2, 1 }, { 1, 2 },{2,2} };
        // int[][] arr = { { 0, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 2, 0 } };
        // int[][] arr = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};
        int[][] arr = {{1,0},{2,2},{2,0},{0,1},{1,1}};
        

        String st = tictactoe(arr);

        System.out.println("Winner : " + st);

    }
}
