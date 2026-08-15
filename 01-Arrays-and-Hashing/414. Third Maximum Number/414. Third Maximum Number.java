1class Solution {
2    public int thirdMax(int[] nums) {
3       
4        Integer max=null;
5         Integer max2=null;
6        Integer max3=null;
7        
8        for(int num :nums)
9        {
10            if((max!=null&&max.equals(num))||(max2!=null&&max2.equals(num))||(max3!=null&&max3.equals(num)))continue;
11        
12        
13            if(max==null||num>max)
14            {
15                max3=max2;
16                max2=max;
17                max=num;
18            }
19            else if(max2==null||num>max2)
20            {
21                max3=max2;
22                max2=num;
23            }
24            else if(max3==null||num>max3)
25            {
26                max3=num;
27            }
28            
29        }
30        if(max3==null)return (int)max;
31        return (int) max3;
32        
33    }
34}