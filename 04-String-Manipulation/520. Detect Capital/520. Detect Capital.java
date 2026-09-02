1class Solution {
2    public boolean detectCapitalUse(String word) {
3        int count=0;
4        int n= word.length();
5        for(int i=0;i<n;i++)
6        {
7          if(Character.isUpperCase(word.charAt(i)))count++;
8        }
9        if(count==n)return true;
10        if(count==0)return true;
11        if(count==1&&Character.isUpperCase(word.charAt(0)))return true;
12        return false;
13        
14    }
15}