1class Solution {
2    public int findDuplicate(int[] nums) {
3        HashMap<Integer,Integer>ans = new HashMap<>();
4        int max =0;
5        int key =0;
6        for(int x :nums)ans.put(x,ans.getOrDefault(x,0)+1);
7        for(Map.Entry<Integer,Integer>entry:ans.entrySet())
8        {
9            if(max<entry.getValue())
10            {
11                max=entry.getValue();
12                key = entry.getKey();
13
14            }
15        }
16        return key;
17    }
18}