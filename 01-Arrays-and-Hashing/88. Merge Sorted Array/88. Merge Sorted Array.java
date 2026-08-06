1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        for(int i=0;i<n;i++)
4        {
5            nums1[m+i]=nums2[i];
6        }
7        Arrays.sort(nums1);
8
9        
10        
11    }
12}