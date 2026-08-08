1class Solution {
2    public int heightChecker(int[] heights) {
3        int n = heights.length;
4        int []exp=new int [n];
5        for(int i=0;i<n;i++)
6        {
7            exp[i]=heights[i];
8        }
9        Arrays.sort(exp);
10        int count =0;
11        for(int i=0;i<n;i++)
12        {
13            if(exp[i]!=heights[i])
14            {
15                count++;
16            }
17        }
18        return count;
19    }
20}