1class Solution {
2    public int[] findErrorNums(int[] nums) {
3        int n= nums.length;
4       HashSet <Integer> ans = new HashSet<>();
5       int []p=new int[2];
6       for(int i=0;i<n;i++)ans.add(nums[i]);
7       for(int i=1;i<=n;i++)if(!ans.contains(i))p[1]=i;
8       for(int i=0;i<n;i++)
9       {
10        for(int j=0;j<n;j++)
11        {
12            if(nums[i]==nums[j]&&i!=j)
13            {
14                p[0]=nums[i];
15            }
16        }
17       }
18       return p;
19
20        
21    }
22
23}