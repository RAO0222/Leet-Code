class Solution {
    public boolean findSubarrays(int[] nums) {
        int n= nums.length;
        if(n<2)return false;
        HashSet<Integer> ans = new HashSet<>();
        int sum=nums[0]+nums[1];
        ans.add(sum);
        for(int i=1;i<n-1;i++)
        {
           sum+=nums[i+1];
           sum-=nums[i-1];
           if(ans.contains(sum))return true;
           ans.add(sum);
        }
        return false;
        
    }
}