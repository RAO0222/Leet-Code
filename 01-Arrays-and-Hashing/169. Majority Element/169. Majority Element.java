1class Solution {
2    public int majorityElement(int[] nums) {
3        HashMap <Integer,Integer> ans  = new HashMap<>();
4        for(int x : nums)
5        {
6          ans.put(x,ans.getOrDefault(x,0)+1);
7        }
8        for(Map.Entry<Integer,Integer> entry :ans.entrySet())
9        {
10            int element = entry.getKey();
11            int freq = entry.getValue();
12            if(freq>(nums.length/2))
13            {
14                return element;
15            }
16        }
17        return 0;
18
19        
20    }
21}