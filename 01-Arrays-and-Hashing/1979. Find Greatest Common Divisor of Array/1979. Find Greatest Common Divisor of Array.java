1class Solution {
2    public int findGCD(int[] nums) {
3        int max=nums[0];
4        int min = nums[0];
5        for(int num:nums)
6        {
7            max=Math.max(max,num);
8            min=Math.min(min,num);
9        }
10        int rem = max;
11        while(rem!=0)
12        {
13            rem=max%min;
14            max=min;
15            min=rem;
16        }
17        return max;
18        
19    }
20}