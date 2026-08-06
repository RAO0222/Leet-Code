1class Solution {
2    public int[] sortedSquares(int[] nums) {
3        int n=nums.length;
4        for(int i=0;i<n;i++)
5        {
6            nums[i]=nums[i]*nums[i];
7        }
8        Arrays.sort(nums);
9        return nums;
10        
11    }
12}