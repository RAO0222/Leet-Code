1class Solution {
2    public boolean containsDuplicate(int[] nums) {
3        HashMap <Integer,Integer> ans = new HashMap<>();
4        for(int x : nums)
5        {
6            ans.put(x,ans.getOrDefault(x,0)+1);
7        }
8        for(Map.Entry<Integer,Integer>entry:ans.entrySet())
9        {
10            int freq= entry.getValue();
11            if(freq>=2)
12            {
13                return true;
14            }
15        }
16        return false;
17    }
18}