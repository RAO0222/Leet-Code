1class Solution {
2    public List<Integer> majorityElement(int[] nums) {
3        HashMap <Integer,Integer> ans = new HashMap<>();
4        HashSet <Integer> p = new HashSet<>();
5        ArrayList<Integer> l = new ArrayList<>();
6        int n=nums.length;
7        for(int x:nums)
8        {
9            ans.put(x,ans.getOrDefault(x,0)+1);
10        }
11        for(int x :nums)
12        {
13            if(ans.get(x)>n/3)
14            {
15                p.add(x);
16            }
17
18        }
19        for(int i:p)
20        {
21            l.add(i);
22        }
23        return l;
24        
25    }
26}