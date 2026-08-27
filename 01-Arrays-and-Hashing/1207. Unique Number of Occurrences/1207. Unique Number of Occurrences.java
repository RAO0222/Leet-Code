1class Solution {
2    public boolean uniqueOccurrences(int[] arr) {
3        int n= arr.length;
4        HashMap<Integer,Integer> ans = new HashMap<>();
5        HashSet<Integer> p = new HashSet<>();
6        for(int x:arr)
7        {
8            ans.put(x,ans.getOrDefault(x,0)+1);
9        }
10        for(Map.Entry<Integer,Integer> entry :ans.entrySet())
11        {
12            if(p.contains(entry.getValue()))return false;
13            p.add(entry.getValue());
14        }
15        return true;
16
17        
18    }
19}