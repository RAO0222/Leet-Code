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
12    public ListNode reverseList(ListNode head) {
13        ArrayList<Integer> ans = new ArrayList<>();
14        ListNode current = head;
15        while(current!=null)
16        {
17            ans.add(current.val);
18            current=current.next;
19        }
20        current=head;
21        int n=ans.size()-1;
22        while(n>=0)
23        {
24            current.val=ans.get(n);
25            current=current.next;
26            n--;
27        }
28        return head;
29
30        
31    }
32}