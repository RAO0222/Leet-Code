1class Solution {
2    public int[] resultArray(int[] nums) {
3        int n= nums.length;
4        ArrayList <Integer> ans1 = new ArrayList <>(); 
5        ArrayList <Integer> ans2 = new ArrayList<>();
6        if(n<2)return nums;
7        ans1.add(nums[0]);
8        ans2.add(nums[1]);
9        int i=2;
10        while(i<n)
11        {
12          if(ans1.get(ans1.size()-1)>ans2.get(ans2.size()-1))
13          {
14            ans1.add(nums[i]);
15            
16          }
17          else
18          {
19            ans2.add(nums[i]);
20           
21          }
22          i++;
23        }
24        int l=ans1.size();
25        int m= ans2.size();
26        for(int j=0;j<l;j++)
27        {
28          nums[j]=ans1.get(j);
29        }
30        for(int j=0;j<m;j++)
31        {
32            nums[j+l]=ans2.get(j);
33        }
34
35     return nums;   
36    }
37}