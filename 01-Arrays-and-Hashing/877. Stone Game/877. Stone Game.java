1class Solution {
2    public boolean stoneGame(int[] piles) {
3        Arrays.sort(piles);
4        int a=0;
5        int b=0;
6        for(int i=piles.length;i>0;i--)
7        {
8           if(i%2==0)
9           {
10            a=a+piles[i-1];
11           }
12           else
13           {
14            b=b+piles[i-1];
15           }
16        }
17        if(a>b)return true;
18        else return false;
19        
20    }
21}