1class Solution {
2    public int countCommas(int n) {
3        if(n<1000)return 0;
4        return n-1000+1;
5        
6    }
7}