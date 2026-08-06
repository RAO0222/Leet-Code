1class Solution {
2    public int[] sortArrayByParityII(int[] nums) {
3        int n=nums.length;
4        int i=0;
5        int j=1;
6        while(j<n&&i<n)
7        {
8            if(nums[i]%2==0)
9            {
10                i=i+2;
11            }
12            else if(nums[j]%2==1)
13            {
14                j=j+2;
15            }
16            else
17            {
18                int temp=nums[i];
19                nums[i]=nums[j];
20                nums[j]=temp;
21                i=i+2;
22                j=j+2;
23            }
24        }
25        return nums;
26
27        
28    }
29}