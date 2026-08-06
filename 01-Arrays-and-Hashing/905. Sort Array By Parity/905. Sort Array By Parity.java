1class Solution {
2    public int[] sortArrayByParity(int[] nums) {
3        int n=nums.length;
4        int i=0;
5        int j=1;
6        while(j<n)
7        {
8            if(nums[i]%2==0)
9            {
10                i++;
11                j++;
12            }
13            else if(nums[j]%2!=0)
14            {
15                j++;
16            }
17            else
18            {
19                int temp=nums[i];
20                nums[i]=nums[j];
21                nums[j]=temp;
22                i++;
23                j=i+1;
24
25            }
26        }
27        return nums;
28        
29    }
30}