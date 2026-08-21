1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int n=matrix.length;
4        int m=matrix[0].length;
5        int i=0;
6        int j=m-1;
7        while(i<n&&j>=0)
8        {
9            if(matrix[i][j]==target)return true;
10            else if(matrix[i][j]>target)j--;
11            else i++;
12        }
13        return false;
14    }
15}