1class Solution {
2    public String removeOuterParentheses(String s) {
3        String ans=;
4        int count =0;
5        int n= s.length();
6        for(int i=0;i<n;i++)
7        {
8            if(s.charAt(i)=='(')
9            {
10                if(count>0)ans=ans+'(';
11                count++;
12            }
13            else
14            {
15                count--;
16                if(count>0)ans=ans+')';
17            }
18            
19        }
20        return ans;
21        
22    }
23}