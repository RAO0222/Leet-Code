1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n=nums.length;
4        int max=0;
5        HashSet<Integer> ans=new HashSet<>();
6        for(int i=0;i<n;i++)
7        {
8            ans.add(nums[i]);
9            max=Math.max(max,nums[i]);
10        }
11        for(int i=1;i<max;i++)
12        {
13            if(!ans.contains(i))return i;
14        }
15        return max+1;
16    }
17}