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
12    public ListNode deleteMiddle(ListNode head) {
13        if(head==null||head.next==null)return null;
14        if(head.next.next==null)
15        {
16            head.next=null;
17            return head;
18        }
19        ListNode slow=head;
20        ListNode fast = head;
21        ListNode prev=head;
22        while(fast!=null&&fast.next!=null)
23        {
24            fast=fast.next.next;
25            prev=slow;
26            slow=slow.next;
27        }
28        prev.next=slow.next;
29        return head;
30        
31    }
32}