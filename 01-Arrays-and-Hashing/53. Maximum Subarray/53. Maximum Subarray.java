1class Solution {
2    public int maxSubArray(int[] nums) {
3        int max=nums[0];
4        int sum=0;
5        int n= nums.length;
6        for(int i=0;i<n;i++)
7        {
8          sum=sum+nums[i];
9          if(sum>max)max=sum;
10          if(sum<0)sum=0;
11           
12           
13           
14        }
15        return max;
16
17        
18    }
19}