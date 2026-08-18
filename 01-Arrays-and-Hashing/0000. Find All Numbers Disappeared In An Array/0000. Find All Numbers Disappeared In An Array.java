1class Solution {
2    public List<Integer> findDisappearedNumbers(int[] nums) {
3        int [] freq= new int [nums.length+1];
4        List <Integer> result = new ArrayList<>();
5        for(int i=0;i<nums.length;i++)
6        {
7            freq[nums[i]]++;
8        }
9        for(int i=1;i<freq.length;i++)
10        {
11            if(freq[i]==0)
12            {
13                result.add(i);
14            }
15        }
16        return result;
17
18
19        
20    }
21}