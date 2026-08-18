1class Solution {
2    public int[] smallerNumbersThanCurrent(int[] nums) {
3        int n= nums.length;
4        int []ans=new int[n];
5        for(int i=0;i<n;i++)
6        {
7            for(int j=0;j<n;j++)
8            {
9                if(nums[i]>nums[j]&&i!=j)ans[i]++;
10            }
11        }
12        return ans;
13        
14    }
15}