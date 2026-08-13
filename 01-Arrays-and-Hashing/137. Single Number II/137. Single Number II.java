1class Solution {
2    public int singleNumber(int[] nums) {
3        HashMap<Integer,Integer>ans =new HashMap<>();
4        for(int x:nums)
5        {
6            ans.put(x,ans.getOrDefault(x,0)+1);
7        }
8        for(Map.Entry<Integer,Integer>entry:ans.entrySet())
9        {
10            if(entry.getValue()==1)
11            {
12                return entry.getKey();
13            }
14        }
15        return 1;
16        
17    }
18}