1class Solution {
2    public boolean isPalindrome(String s) {
3        ArrayList<Character> ans = new ArrayList<>();
4        int n= s.length();
5        for(int i =0;i<n;i++)
6        {
7            if(Character.isLetterOrDigit(s.charAt(i)))ans.add(Character.toLowerCase(s.charAt(i)));
8        }
9        int l=ans.size()-1;
10        int i=0;
11        while(i<l)
12        {
13            if(ans.get(i)!=ans.get(l))return false;
14            i++;
15            l--;
16        }
17        return true;
18
19        
20    }
21}