1class Solution {
2    public int numJewelsInStones(String jewels, String stones) {
3        int count =0;
4     HashSet<Character> ans =new HashSet<>();
5     for(int i=0;i<jewels.length();i++)ans.add(jewels.charAt(i));
6     for(int i=0;i<stones.length();i++)
7     {
8        if(ans.contains(stones.charAt(i)))count++;
9     }
10     return count;
11        
12    }
13}