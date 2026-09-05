1class Solution {
2    public boolean isThree(int n) {
3        int count =0;
4        int num=n;
5        for(int i=num;i>0;i--)
6        {
7            if(num%i==0)count++;
8        }
9        if(count==3)return true;
10        return false;
11    }
12}