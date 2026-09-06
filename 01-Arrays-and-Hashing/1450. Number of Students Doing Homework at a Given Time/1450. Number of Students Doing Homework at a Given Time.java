1class Solution {
2    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
3        int count =0;
4        int n= startTime.length;
5        for(int i=0;i<n;i++)
6        {
7            if(startTime[i]<=queryTime&&queryTime<=endTime[i])count++;
8        }
9        return count;
10        
11    }
12}