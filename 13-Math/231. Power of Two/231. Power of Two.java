1class Solution {
2    public boolean isPowerOfTwo(int n) {
3        if((n & (n-1))==0&&n>0)return true;
4        return false;
5        
6    }
7}