1class Solution {
2    public List<List<String>> groupAnagrams(String[] strs) {
3        HashMap<String,List<String>> ans=new HashMap<>();
4        for(int i=0;i<strs.length;i++)
5        {
6            String s=strs[i];
7            char[] cArray = s.toCharArray();
8            Arrays.sort(cArray);
9            String sortedS=new String(cArray);
10            ans.putIfAbsent(sortedS,new ArrayList<>());
11            ans.get(sortedS).add(s);
12        } 
13        return new ArrayList<>(ans.values());
14        
15    }
16}