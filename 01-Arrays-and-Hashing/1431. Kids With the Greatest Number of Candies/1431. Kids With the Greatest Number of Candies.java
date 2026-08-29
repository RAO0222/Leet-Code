1class Solution {
2    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
3     int n= candies.length;
4    List<Boolean> ans = new ArrayList<>();
5     int max =0;
6     for(int i=0;i<n;i++)
7     {
8        max=Math.max(max,candies[i]);
9     }
10     for(int i=0;i<n;i++)
11     {
12        if(max<=(candies[i]+extraCandies))ans.add(true);
13        else ans.add(false);
14     }
15     return ans;
16        
17    }
18}