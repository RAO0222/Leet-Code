1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int m= matrix.length;
4        int n= matrix[0].length;
5        int low=0;
6        int high=(m*n)-1;
7        while(high>=low)
8        {
9            int mid = low+(high-low)/2;
10            int i=mid/n;
11            int  j=mid%n;
12            if(matrix[i][j]==target)return true;
13            else if(matrix[i][j]>target)high=mid-1;
14            else low=mid+1;
15        }
16        return false;
17        
18    }
19}