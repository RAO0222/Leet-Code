1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public boolean isPalindrome(ListNode head) {
13        ListNode current=head;
14        ArrayList<Integer> ans = new ArrayList<>();
15        while(current!=null)
16        {
17            ans.add(current.val);
18            current=current.next;
19        }
20        int n= ans.size()-1;
21        int i=0;
22        while(i<n)
23        {
24           if(ans.get(i)!=ans.get(n))return false;
25           i++;
26           n--;
27        }
28        return true;
29        
30    }
31}