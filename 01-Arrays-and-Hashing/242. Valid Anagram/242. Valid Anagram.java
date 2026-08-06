1class Solution {
2    public boolean isAnagram(String s, String t) {
3        char[] str1 = s.toCharArray();
4        char[] str2 =t.toCharArray();
5        int n= str1.length;
6        int m= str2.length;
7        int []arr=new int[26];
8        for(int i=0;i<n;i++)
9        {
10            arr[str1[i]-'a']++;
11        }
12        for(int i=0;i<m;i++)
13        {
14           arr[str2[i]-'a']--;
15        }
16        for(int i=0;i<26;i++)
17        {
18            if(arr[i]!=0)
19            {
20                return false;
21            }
22        }
23        return true;
24        
25        
26    }
27}