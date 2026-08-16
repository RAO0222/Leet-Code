1class Solution {
2    public int maximumProduct(int[] nums) {
3        int n= nums.length;
4        Arrays.sort(nums);
5        return Math.max((nums[n-1]*nums[n-2]*nums[n-3]),(nums[0]*nums[1]*nums[n-1]));
6    }
7}