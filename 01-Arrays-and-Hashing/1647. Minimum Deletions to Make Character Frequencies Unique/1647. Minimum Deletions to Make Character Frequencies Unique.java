1class Solution {
2    public int minDeletions(String s) {
3        HashMap<Character,Integer>ans=new HashMap<>();
4        HashSet <Integer> p = new HashSet<>();
5        int n = s.length();
6        int count =0;
7        for(int i=0;i<n;i++)
8        {
9            int freq = ans.getOrDefault(s.charAt(i),0)+1;
10            ans.put(s.charAt(i),freq);
11        }
12        for(Map.Entry<Character,Integer>entry:ans.entrySet())
13        {
14            int val=entry.getValue();
15            if(p.contains(val))
16            {
17                while(val>0&&p.contains(val))
18                {
19                    val=val-1;
20                    count++;
21                }
22            }
23            p.add(val);
24        }
25        return count;
26        
27    }
28}