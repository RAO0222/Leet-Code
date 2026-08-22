1class Solution {
2    public int countDigits(int num) {
3        int p=num;
4        int count =0;
5        while(num!=0)
6        {
7          if(p%(num%10)==0)count++;
8          num=num/10;
9        }
10        return count;
11        
12    }
13}