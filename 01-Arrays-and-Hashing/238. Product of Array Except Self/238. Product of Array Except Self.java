1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n= nums.length;
4        int pref=nums[0];
5        int suf= nums[n-1];
6        int []ans = new int [n];
7        for(int i=0;i<n;i++)
8        {
9            if(i==0)ans[0]=1;
10             else if(i==1)ans[1]=nums[0];
11            else 
12            {
13                pref=pref*nums[i-1];
14                ans[i]=pref;
15            }
16        
17
18        }
19        for(int i=n-2;i>=0;i--)
20        {
21            if(i==n-2)ans[i]=ans[i]*nums[i+1];
22            else
23            {
24                suf=suf*nums[i+1];
25                ans[i]=ans[i]*suf;
26            }
27        }
28        return ans;
29        
30    }
31}