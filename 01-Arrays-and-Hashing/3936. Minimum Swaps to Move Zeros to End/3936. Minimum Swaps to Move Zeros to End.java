1class Solution {
2    public int minimumSwaps(int[] nums) {
3        int count =0;
4        int j= nums.length-1;
5        int i=0;
6        while(i<=j)
7        {
8            if(nums[i]==0&&nums[j]!=0)
9            {
10                count++;
11                i++;
12                j--;
13            }
14            else if (nums[i]==0&&nums[j]==0)j--;
15            else
16            {
17                i++;
18            }
19
20        }
21        return count;
22        
23    }
24}