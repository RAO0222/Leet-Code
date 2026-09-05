1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n= nums.length;
4        int []ans=new int [n];
5        ans[n-1]=nums[n-1];
6        for(int i=n-2;i>=0;i--)
7        {
8            ans[i]= Math.min(nums[i],ans[i+1]);
9        }
10        int max=nums[0];
11        for(int i=0;i<n;i++)
12        {
13          max=Math.max(max,nums[i]);
14          if(max-ans[i]<=k)return i;  
15        }
16        return -1;
17        
18    }
19}