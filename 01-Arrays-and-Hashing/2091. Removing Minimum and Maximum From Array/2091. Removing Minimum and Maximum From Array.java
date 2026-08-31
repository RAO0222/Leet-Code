1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int i=0;
4        int j=0;
5        int n= nums.length;
6        for(int l=0;l<n;l++)
7        {
8            if(nums[l]<nums[i])
9            {
10               i=l;
11            }
12            if(nums[l]>nums[j])
13            {
14                j=l;
15            }
16        }
17            int left=Math.min(i,j);
18            int right=Math.max(i,j);
19            int removeFront=right+1;
20            int removeBack=n-left;
21            int removeBoth=(left+1)+(n-right);
22            return Math.min(removeFront,Math.min(removeBack,removeBoth));
23    }
24}