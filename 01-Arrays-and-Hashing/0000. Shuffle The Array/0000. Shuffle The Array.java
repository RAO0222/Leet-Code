1class Solution {
2    public int[] shuffle(int[] nums, int n) {
3        int []ans=new int[2*n];
4        int j=0;
5        int p=0;
6        for(int i=0;i<2*n;i++)
7        {
8            if(i%2==0)
9        {
10            ans[i]=nums[p];
11            p++;
12        }
13            else
14            {
15                ans[i]=nums[n+j];
16                j++;
17            }
18            
19        }
20        return ans;
21    }
22}