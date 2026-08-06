class Solution {
public:
    int largestPerimeter(vector<int>& nums) {
        swapMaxElement(nums, nums.size() - 1);
        swapMaxElement(nums, nums.size() - 2);
        for (int i = nums.size() - 1; i >= 2; i--) {
            swapMaxElement(nums, i - 2);
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        }
        return 0;
    }
    
    void swapMaxElement(vector<int>& nums, int index) {
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i <= index; i++)
            if (nums[i] > max)
                max = nums[(maxIndex = i)];
        nums[maxIndex] = nums[index];
        nums[index] = max;
    }
};