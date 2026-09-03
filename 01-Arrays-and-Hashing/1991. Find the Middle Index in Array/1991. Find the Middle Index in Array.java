1class Solution {
2    public int findMiddleIndex(int[] nums) {
3        int sum=0;
4        int leftSum=0;
5        int n= nums.length;
6        for(int num:nums)sum+=num;
7        for(int i=0;i<n;i++)
8        {
9            if(i==0)
10            {
11                if(sum-nums[i]==0)return i;
12            }
13            else
14            {
15                leftSum+=nums[i-1];
16                if((sum-nums[i]-leftSum)==leftSum)return i;
17            }
18        }
19        return -1;
20       
21
22        
23    }
24}