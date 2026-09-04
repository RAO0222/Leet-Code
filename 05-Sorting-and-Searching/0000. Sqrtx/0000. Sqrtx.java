1class Solution {
2    public int mySqrt(int x) {
3        int high=x;
4        int low=0;
5        int ans=0;
6        while(high>=low)
7        {
8            int mid=low+(high-low)/2;
9            if((long)mid*mid==x)return mid;
10            else if((long)mid*mid>x)high=mid-1;
11            else 
12            {
13                ans=mid;
14                low=mid+1;
15            }
16        }
17        return ans;
18        
19    }
20}