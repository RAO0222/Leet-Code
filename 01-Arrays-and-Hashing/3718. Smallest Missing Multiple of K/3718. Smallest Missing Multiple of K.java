1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        int n=nums.length;
4        HashSet<Integer> ans=new HashSet<>();
5        int[]p=new int[n];
6        for(int i=0;i<n;i++)
7        {
8            ans.add(nums[i]);
9        }
10        for(int i=1;i<=n;i++)
11        {
12            nums[i-1]=i*k;
13        }
14        for(int i=0;i<n;i++)
15        {
16            if(!ans.contains(nums[i]))return nums[i];
17        }
18        return (n+1)*k;
19
20        
21    }
22}