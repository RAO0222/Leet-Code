class Solution {
    public int minMoves2(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<n/2;i++)
        {
         sum+=(nums[n/2]-nums[i]);
         sum+=(nums[n-1-i]-nums[n/2]);
        }
        return sum;
        
    }
}