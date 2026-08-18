1class Solution {
2    public int arraySign(int[] nums) {
3        int count =0;
4        for(int i=0;i<nums.length;i++)
5        {
6            if(nums[i]==0)return 0;
7            else if(nums[i]<0)count++;
8            
9        }
10        if(count%2==0)return 1;
11        else return -1;
12        
13    }
14}