1class Solution {
2    public int[] singleNumber(int[] nums) {
3        HashMap<Integer,Integer>ans=new HashMap<>();
4        int[] p=new int[2];
5        int l=0;
6        for(int x:nums)
7        {
8          ans.put(x,ans.getOrDefault(x,0)+1);
9        }
10        for(Map.Entry<Integer,Integer>entry:ans.entrySet())
11        {
12            if(entry.getValue()==1)
13            {
14              p[l]=entry.getKey();
15              l++;
16            }
17        }
18        return p;
19    }
20}