1class Solution {
2    public boolean checkDivisibility(int n) {
3        int p =n;
4        int sum =0;
5        int prod=1;
6        while(n!=0)
7        {
8            sum=sum+(n%10);
9           prod=prod*(n%10);
10            n=n/10;
11        }
12        if(p%(sum+prod)==0)return true;
13        return false;
14        
15    }
16}