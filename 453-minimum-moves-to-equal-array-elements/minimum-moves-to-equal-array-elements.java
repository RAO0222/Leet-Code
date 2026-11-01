class Solution {
    public int minMoves(int[] nums) {
        int n= nums.length;
        int max=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.min(max,nums[i]);
        }
        int moves=0;
        for(int i=0;i<n;i++)
        {
            moves=moves+(nums[i]-max);
        }
        return moves;
        
    }
}