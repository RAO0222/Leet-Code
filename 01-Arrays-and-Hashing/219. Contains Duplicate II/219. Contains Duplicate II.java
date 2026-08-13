1class Solution {
2    public boolean containsNearbyDuplicate(int[] nums, int k) {
3        HashMap<Integer,Integer> ans = new HashMap<>();
4        int n= nums.length;
5       for(int i =0;i<n;i++)
6       {
7        if(ans.containsKey(nums[i]))
8        {
9            int prev=ans.get(nums[i]);
10            if(i-prev<=k)
11            {
12                return true;
13            }
14        }
15        ans.put(nums[i],i);
16       }
17       return false;
18    }
19}