1class Solution {
2    public int differenceOfSum(int[] nums) {
3        int sum=0;
4        int add=0;
5        int n= nums.length;
6        for(int i=0;i<n;i++)
7        {
8            add=add+nums[i];
9            int s=0;
10            while(nums[i]>9)
11            {
12             s=s+ nums[i]%10;
13             nums[i]=nums[i]/10;
14            }
15            nums[i]=nums[i]+s;
16            sum=sum+nums[i];
17        }
18        return add-sum;
19        
20    }
21}