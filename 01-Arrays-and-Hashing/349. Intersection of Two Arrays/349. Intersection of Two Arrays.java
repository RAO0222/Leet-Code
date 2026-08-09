1class Solution {
2    public int[] intersection(int[] nums1, int[] nums2) {
3        HashSet <Integer> ans = new HashSet<>();
4        for(int i=0;i<nums1.length;i++)
5        {
6            for(int j=0;j<nums2.length;j++)
7            {
8                if(nums1[i]==nums2[j])
9                {
10                    ans.add(nums1[i]);
11                }
12            }
13        }
14        int[] p= new int[ans.size()];
15        int i=0;
16        for(int x:ans)
17        {
18            p[i++]=x;
19        }
20        return p;
21        
22    }
23}